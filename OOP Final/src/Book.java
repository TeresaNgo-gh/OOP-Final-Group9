
public class Book {
	private String name;
	private String publisher;
	private String author;
	private int year;
	private int BID;
	private boolean isBorrowed = false;
	
	public Book(String name, String publisher, String author, int year, int BID) {
		this.name = name;
		this.publisher = publisher;
		this.author = author;
		this.year = year;
		this.BID = BID;
	}

	public String getName() {
		return name;
	}

	public String getPublisher() {
		return publisher;
	}
	
	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public int getBID() {
		return BID;
	}
	
	public String toString() {
		return "(" + getBID() + ") " + getName() + ", " + getAuthor() + ", " + getPublisher() + ", " + getYear();
	}
}
