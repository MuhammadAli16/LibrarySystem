package library;

public abstract class Item {
	private static int counter = 0;
	
	private int id;
	private String title;
	private String author;
	private int publicationDate;
	private Integer takenUserID;
	
	
	
	public Item(String title, String author, int publicationDate) {
		super();
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		
		this.id = counter++; 
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(int publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public Integer getTakenUserID() {
		return takenUserID;
	}

	public void setTakenUserID(Integer takenUserID) {
		this.takenUserID = takenUserID;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", author=" + author + ", publicationDate=" + publicationDate
				+ ", takenUserID=" + takenUserID + "]";
	}

	
	
	
	
}
