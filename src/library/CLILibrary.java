package library;

import java.util.ArrayList;
import java.util.Scanner;

import systems.LibrarySystem;

public class CLILibrary {

	static LibrarySystem ls;

	public static void main(String[] args) {
		ls = LibrarySystem.getInstance();
		ls.generateData();

		CLILibrary lol = new CLILibrary();
		lol.showMenu();
	}

	public void showMenu() {

		int input = 0;

		do {
			System.out.println("MENU");
			System.out.println("1.View Books");
			System.out.println("2.View People");
			System.out.println("3.Check Out Book");
			System.out.println("4.Check In Book");
			System.out.println("5.Update Book");
			System.out.println("6.Add Book");
			System.out.println("7.Delete Book");
			System.out.println("8.Update Person");
			System.out.println("9.Add Person");
			System.out.println("10.Delete Person");
			
			System.out.println("99.Quit");
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
			} catch (Exception e) {
				// chastise the user
			}
			selectMenu(input);
		} while (true);

	}

	public void selectMenu(int input) {
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
		case 10:
			deletePerson();
			break;
		case 99:
			System.exit(0);
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

		ArrayList<Person> list = ls.getPersonManager().getThePeople();
		for (int x = 0; x < list.size(); x++) {
			System.out.println(x + ": " + list.get(x).toString());
		}

	}

	public void showPeopleWithBooks() {

		ArrayList<Person> list = ls.getPersonManager().getThePeople();
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getTaken().size() > 0)
				System.out.println(x + ": " + list.get(x).toString());
		}

	}

	public void showBooksTakenByUser(Integer a) {
		ArrayList<Item> list = ls.getLibraryList();
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getTakenUserID() == a)
				System.out.println(x + ": " + list.get(x).toString());
		}
		
		
	}

	// Select person then select book
	public void checkOutBook() {
		Item selectedItem = null;
		Person selectedPerson = null;

		showPeople();
		Scanner sc = new Scanner(System.in);
		// select person
		System.out.println("Who is taking the item?");
		int input = sc.nextInt();
		ArrayList<Person> list = ls.getPersonManager().getThePeople();
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
		boolean success = false;
		try{
			success = ls.checkOut(selectedItem.getId(), selectedPerson.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (success) {
			System.out.println("Book checked out!");
		} else {
			System.out.println("Failed! Book may already be checked out");
		}

	}

	// Select person then select book
	public void checkInBook() {
		Item selectedItem = null;
		Person selectedPerson = null;
		
		showPeopleWithBooks();

		Scanner sc = new Scanner(System.in);
		System.out.println("Who is returning the item?");
		int input = sc.nextInt();
		ArrayList<Person> list = ls.getPersonManager().getThePeople();
		for (int x = 0; x < list.size(); x++) {
			if (list.get(x).getId() == input) {
				selectedPerson = list.get(x);
				System.out.println("Youve Selected: " + list.get(x).toString());
			}
		}

		showBooksTakenByUser(input);
		System.out.println("Which Item?");
		input = sc.nextInt();
		ArrayList<Item> listItem = ls.getLibraryList();
		for (int x = 0; x < listItem.size(); x++) {
			if (listItem.get(x).getId() == input) {
				selectedItem = listItem.get(x);
				System.out.println("Youve Selected: " + listItem.get(x).toString());
			}
		}

		boolean success = ls.checkIn(selectedItem.getId(), selectedPerson.getId());
 
		if (success){
			System.out.println("Book Returned");
		} else {
			System.out.println("Error");
		}

	}
	
	public void deletePerson(){
		showPeople();
		Scanner sc = new Scanner(System.in);
		System.out.println("Which user to delete?");
		int input = sc.nextInt();
		boolean success = ls.getPersonManager().deletePerson(input);
		
		if (success){
			System.out.println("Successfully removed user");
		} else {
			System.out.println("Failed! User possibly has books or does not exist");
		}
	}

}
