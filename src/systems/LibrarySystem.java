package systems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import library.Book;
import library.Item;
import library.Newspaper;
import library.Person;

public class LibrarySystem implements LibraryInterface {

	// IGNORE - Just here to add data to application
	public void generateData() {
		// Add books
		Item book = new Book("Harry Potter", "JK", 1990, "");
		Item book2 = new Book("Harry Potter 2", "JK", 1995, "");
		addBook(book);
		addBook(book2);
		// Add people
		Person bob = new Person("Bob", 35);
		Person timmy = new Person("Timmy", 20);
		getPersonManager().addPerson(bob);
		getPersonManager().addPerson(timmy);
	}

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
	public void removeBook(Item i) {
		if (i.getTakenUserID() != null) {
			libraryList.remove(i);
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

	// TODO
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

	Item findItem(int ID) {
		for (Item item : libraryList) {
			if (item.getId() == ID) {
				return item;
			}
		}
		return null;
	}

}
