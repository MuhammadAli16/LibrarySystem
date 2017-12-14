package library;

public interface LibraryInterface {
	
	public void checkOut(Item i, Person p); 

	public void checkIn(Item i, Person p);

	public void addBook(Item i);

	public void removeBook(Item i);

	public void updateItem(Item i);

	
}
