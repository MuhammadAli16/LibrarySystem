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

	@Override
	public String toString() {
		return "Book [publisher=" + publisher + ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getAuthor()="
				+ getAuthor() + ", getPublicationDate()=" + getPublicationDate() + ", getTakenUserID()="
				+ getTakenUserID() + "]";
	}
	
	
		
}
