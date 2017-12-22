package systems;

import library.Item;

public interface LibraryInterface {
	
	//public boolean checkOut(Item i, Person p); 
	boolean checkOut(int itemID, int personID);
	
	//public boolean checkIn(Item i, Person p);
	public boolean checkIn(int itemID, int personID);
	
	public void addBook(Item i);

//	public void removeBook(Item i);
//	boolean removeBook(int bookID);
	boolean removeItem(int itemID);

	public void updateItem(Item i);

	

	
	
}
