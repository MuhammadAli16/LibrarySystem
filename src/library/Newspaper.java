package library;

public class Newspaper extends Item{
	
	private int articles;
	
	public Newspaper(String title, String author, int publicationDate, boolean istaken, int articles) {
		super(title, author, publicationDate, istaken);
		this.articles = articles;
	}

	
	
	
}
