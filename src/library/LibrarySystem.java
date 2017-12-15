package library;

import java.util.ArrayList;

public class LibrarySystem implements LibraryInterface {

	private ArrayList<Item> libraryList = new ArrayList<>();

	// create an object of SingleObject
	private static LibrarySystem instance = new LibrarySystem();

	private LibrarySystem() {
	}

	// Get the only object available
	public static LibrarySystem getInstance() {
		return instance;
	}

	@Override
	public void checkOut(Item i, Person p) {
		p.takeItem(i);
		i.setIstaken(true);
	}

	@Override
	public void checkIn(Item i, Person p) {
		p.returnItem(i);
		i.setIstaken(false);
	}

	@Override
	public void addBook(Item i) {
		libraryList.add(i);
	}

	@Override
	public void removeBook(Item i) {
		if (!i.isIstaken()) {
			libraryList.remove(i);
		}
	}

	@Override
	public void updateItem(Item i) {

	}

	public ArrayList<Item> getLibraryList() {
		return this.libraryList;
	}

	public void checkFreeBooks(ArrayList<Item> libraryList) {
		for (Item i : libraryList) {
			if (i.isIstaken()) {
				i.toString();
			}
		}
	}

}
