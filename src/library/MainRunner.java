package library;

import java.util.Arrays;

import systems.LibrarySystem;

public class MainRunner {

	public static void main(String[] args) {
		
		LibrarySystem ls = LibrarySystem.getInstance();
		
		ls.generateData();

		
		// print the people and books
		System.out.println(Arrays.toString(ls.getLibraryList().toArray()));
		
		System.out.println(Arrays.toString(ls.getPersonManager().getThePeople().toArray()));
	
	}

}
