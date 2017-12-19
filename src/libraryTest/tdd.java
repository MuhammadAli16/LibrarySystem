package libraryTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import library.Book;
import library.Item;
import library.Person;
import systems.LibrarySystem;
import systems.PersonManager;

public class tdd {

	LibrarySystem ls;

	@Before
	public void setUp() {
		ls = LibrarySystem.getInstance();

		// Add books
		Item book = new Book("Harry Potter", "JK", 1990, "");
		Item book2 = new Book("Harry Potter 2", "JK", 1995, "");
		ls.addBook(book);
		ls.addBook(book2);

		// Add people
		Person bob = new Person("Bob", 35);
		Person jimmy = new Person("jimmy", 20);
		ls.getPersonManager().addPerson(bob);
		ls.getPersonManager().addPerson(jimmy);
	}

	@Test
	public void testAddPerson() {
		int previousSize  = ls.getPersonManager().getThePeople().size();
		Person test = new Person("Tester" , 10);
		ls.getPersonManager().addPerson(test);
		assertEquals(previousSize + 1, ls.getPersonManager().getThePeople().size());
		
	}

	@Test
	public void testCheckOut() {
		Item book = ls.getLibraryList().get(0);
		Person person = ls.getPersonManager().getThePeople().get(0);
		ls.checkOut(book.getId(), person.getId());
		// check if user has book with id 0;
		assertEquals(0, person.getTaken().get(0).getId());
		
		// check if book has user with id 0 holding it
		assertEquals(0, book.getTakenUserID().intValue());
	}

}
