
public class Book extends Document{
	private String author;
	
	public Book (String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	/*public void addBook(String title, String author) {
		this.title = title;
		this.author = author;
	}*/
	
	
}
