package library;

public class Newspaper extends Item{
	
	private int articles;
	
	public Newspaper(String title, String author, int publicationDate, int articles) {
		super(title, author, publicationDate);
		this.setArticles(articles);
	}

	public int getArticles() {
		return articles;
	}

	public void setArticles(int articles) {
		this.articles = articles;
	}
	
}
