package library;

import java.util.ArrayList;
import java.util.Scanner;

public class CLILibrary {

	static LibrarySystem ls = new LibrarySystem();
	static PersonManager pm = new PersonManager();

	public static void main(String[] args) {
		ls = new LibrarySystem();
		pm = new PersonManager();

		// Add books
		Item book = new Book("Harry Potter", "JK", 1990, false, "");
		Item book2 = new Book("Harry Potter 2", "JK", 1995, false, "");
		ls.addBook(book);
		ls.addBook(book2);

		// Add people
		Person bob = new Person("Bob", 35);
		pm.addPerson(bob);

		CLILibrary lol = new CLILibrary();
		lol.showMenu();
	}

	public void showMenu() {
		Scanner sc = new Scanner(System.in);

		int input = 0;

		do {
			System.out.println("MENU");
			System.out.println("1.View Books");
			System.out.println("2.View People");
			System.out.println("3.Check Out Book");
			System.out.println("4.Check In Book");
			System.out.println("5.Update Book");
			System.out.println("99.Quit");
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				showMenu();
			}

		} while (input > 5 || input < 0);
		// sc.close();

		// Depending on user input show relevant stuff
		switch (input) {
		case 1:
			showBooks();
			break;
		case 2:
			showPeople();
			break;
		case 3:
			checkOutBook();
			break;
		case 4:
			checkInBook();
			break;
		case 5:
			break;
		case 99:
			break;
		}
	}

	public void showBooks() {

		ArrayList<Item> list = ls.getLibraryList();
		for (int x = 0; x < list.size(); x++) {
			System.out.println(x + ": " + list.get(x).toString());
		}
		

	}

	public void showPeople() {

		ArrayList<Person> list = pm.getThePeople();
		for (int x = 0; x < list.size(); x++) {
			System.out.println(x + ": " + list.get(x).toString());
		}
		

	}
	
	public void showPeopleWithBooks() {

		ArrayList<Person> list = pm.getThePeople();
		for (int x = 0; x < list.size(); x++) {
			if(list.get(x).getTaken().size() > 0)
				System.out.println(x + ": " + list.get(x).toString());
		}
		
	}
	
	public void showBooksTakenByUser(int a){
		
	}
	

	// Select person then select book
	public void checkOutBook() {
		Item selectedItem = null;
		Person selectedPerson = null;
		
		// ls.
		showPeople();
		Scanner sc = new Scanner(System.in);
		// select person
		System.out.println("Who is taking the item?");
		int input = sc.nextInt();
		ArrayList<Person> list = pm.getThePeople();
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getId() == input) {
				selectedPerson = list.get(x);
				System.out.println("Youve Selected: " + list.get(x).toString());
			}
		}

		showBooks();
		// select Book
		System.out.println("Which Item?");
		input = sc.nextInt();
		ArrayList<Item> listItem = ls.getLibraryList();
		for (int x = 0; x < listItem.size(); x++) {
			if (listItem.get(x).getId() == input) {
				selectedItem = listItem.get(x);
				System.out.println("Youve Selected: " + listItem.get(x).toString());
			}
		}
		
		ls.checkOut(selectedItem, selectedPerson);
		System.out.println("hi");
		showMenu();

	}
	
	// Select person then select book
		public void checkInBook() {
			Item selectedItem = null;
			Person selectedPerson = null;
			
			// ls.
			showPeopleWithBooks();
			Scanner sc = new Scanner(System.in);
			// select person
			System.out.println("Who is returning the item?");
			int input = sc.nextInt();
			ArrayList<Person> list = pm.getThePeople();
			for (int x = 0; x < list.size(); x++) {
				if (list.get(x).getId() == input) {
					selectedPerson = list.get(x);
					System.out.println("Youve Selected: " + list.get(x).toString());
				}
			}

			showBooksTakenByUser(input);
			// select Book
			System.out.println("Which Item?");
			input = sc.nextInt();
			ArrayList<Item> listItem = ls.getLibraryList();
			for (int x = 0; x < listItem.size(); x++) {
				if (listItem.get(x).getId() == input) {
					selectedItem = listItem.get(x);
					System.out.println("Youve Selected: " + listItem.get(x).toString());
				}
			}
			
			ls.checkOut(selectedItem, selectedPerson);
			
			showMenu();

		}

}
