package library;

public class Book extends Item {

	private String publisher;

	public Book(String title, String author, int publicationDate, String publisher) {
		super(title, author, publicationDate);
		this.setPublisher(publisher);
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
		
}
