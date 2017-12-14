package library;

public abstract class Item {
	private static int counter = 0;
	
	private int id;
	private String title;
	private String author;
	private int publicationDate;
	private boolean istaken;
	
	
	
	public Item(String title, String author, int publicationDate, boolean istaken) {
		super();
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.istaken = istaken;
		
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
	
	public boolean isIstaken() {
		return istaken;
	}
	
	public void setIstaken(boolean istaken) {
		this.istaken = istaken;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", author=" + author + ", publicationDate=" + publicationDate + ", istaken="
				+ istaken + "]";
	}
	
	
	
}
