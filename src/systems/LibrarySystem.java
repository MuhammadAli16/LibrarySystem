package systems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import library.Book;
import library.Item;
import library.Newspaper;
import library.Person;

public class LibrarySystem implements LibraryInterface {

	private ArrayList<Item> libraryList = new ArrayList<>();
	private PersonManager personManager;
	
	// create an object of SingleObject
	private static LibrarySystem instance = new LibrarySystem();

	private LibrarySystem() {
		personManager = PersonManager.getInstance();
	}

	// Get the only object available
	public static LibrarySystem getInstance() {
		return instance;
	}

	@Override
	public boolean checkOut(int itemID, int personID) {
		Item item = findItem(itemID);
		Person person = personManager.findPerson(personID);

		if (item.getTakenUserID() == null) {
			item.setTakenUserID(personID);
			person.takeItem(item);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean checkIn(int itemID, int personID) {
		Item item = findItem(itemID);
		Person person = personManager.findPerson(personID);

		if (item.getTakenUserID() == (Integer) person.getId()) {
			item.setTakenUserID(null);
			person.returnItem(item);
			return true;
		} else {
			return false;
		}

	}

	public void createBook(String title, String author, int publicationDate, String publisher) {
		Item book = new Book(title, author, publicationDate, publisher);
		addBook(book);
	}

	public void createNewspaper(String title, String author, int publicationDate, int articles) {
		Item newspaper = new Newspaper(title, author, publicationDate, articles);
		addBook(newspaper);

	}

	@Override
	public void addBook(Item i) {
		libraryList.add(i);
	}

	@Override
	public boolean removeItem(int itemID) {
		Item item = findItem(itemID);
		if (item.getTakenUserID() != null) {
			libraryList.remove(item);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateItem(Item i) {

	}

	public ArrayList<Item> getLibraryList() {
		return this.libraryList;
	}

	public PersonManager getPersonManager() {
		return personManager;
	}

	public ArrayList<Item> checkFreeBooks(ArrayList<Item> libraryList) {

		ArrayList<Item> availBooks = new ArrayList<Item>();
		for (Item i : libraryList) {
			if (i.getTakenUserID() == null) {
				availBooks.add(i);
			}
		}

		return availBooks;
	}

	// TODO check if works and need a method to convert arraylist to string
	public void writeToFile(String path, String listStr) {
		// Location and filename
		FileWriter fw;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(path);
			bw = new BufferedWriter(fw);
			bw.write(listStr);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// TODO continued from above
	public String listToStr(ArrayList<Item> list){
		
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < list.size(); x++){
			sb.append(list.get(x).toString());
			sb.append("\n");
		}
		
		return sb.toString();
		
	}
	
	public void readFile(String path) {

		// List to collect Employee objects
		//ArrayList<Person> people = new ArrayList<Person>();
		// Read data from file
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// Read file line by line
			String line = "";

			while ((line = br.readLine()) != null) {

				String[] arrValues = line.split(", ");

				System.out.println(Arrays.toString(arrValues));
				//Person person = new Person(arrValues[0], arrValues[1], Integer.parseInt(arrValues[2]));

				//people.add(person);
			}

		} catch (IOException e1) {
			System.err.println("File might not exist!");
			e1.printStackTrace();
		}

		
		//return people;
	}

	// Method to find item by ID
	Item findItem(int ID) {
		for (Item item : libraryList) {
			if (item.getId() == ID) {
				return item;
			}
		}
		return null;
	}
	
	
	// IGNORE - Just here to add data to application
		public void generateData() {
			// Add books
			Item book = new Book("Harry Potter", "JK", 1990, "Disney Publishings");
			Item book2 = new Book("Harry Potter 2", "JK", 1995, "Disney Publishings");
			Item newsPaper = new Newspaper("Harry Potter 2", "JK", 1995, 30);
			addBook(book);
			addBook(book2);
			addBook(newsPaper);
			// Add people
			Person bob = new Person("Bob", 35);
			Person timmy = new Person("Timmy", 20);
			getPersonManager().addPerson(bob);
			getPersonManager().addPerson(timmy);
		}

}
