package library;

import java.util.ArrayList;
import java.util.Arrays;

public class MainRunner {

	public static void main(String[] args) {
		
		LibrarySystem ls = LibrarySystem.getInstance();
		PersonManager pm = new PersonManager();
		
		// add people
		Person bob = new Person("Bob", 35);
		pm.addPerson(bob);
		
		// add books
		Item book = new Book("Harry Potter", "JK", 1990, false, "");
		Item book2 = new Book("Harry Potter 2", "JK", 1995, false, "");
		ls.addBook(book);
		ls.addBook(book2);
		
		
		System.out.println(Arrays.toString(ls.getLibraryList().toArray()));
		
		// bob takes harry potter
		ls.checkOut(book, bob);
		
		
		System.out.println(Arrays.toString(ls.getLibraryList().toArray()));
		
		System.out.println(bob.toString());
		
	}
	
	
	public static void genPeople(){
		
	}
	
	

}
