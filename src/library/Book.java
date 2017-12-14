package library;

public class Book extends Item {

	private String publisher;

	public Book(String title, String author, int publicationDate, boolean istaken, String publisher) {
		super(title, author, publicationDate, istaken);
		this.publisher = publisher;
	}
	
	
	
	
	
}
