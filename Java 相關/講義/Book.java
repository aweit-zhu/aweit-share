public class Book {

	private int id;

	private String name;

	private double price;
	
	private BookType bookType;

	public Book() {
		this(1, "書本名稱", 10.0);
	}

	public Book(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public BookType getBookType() {
		return bookType;
	}

	public void display() {
		System.out.println("================");
		System.out.println("id:" + id);
		System.out.println("name:" + name);
		System.out.println("price:" + price);
		System.out.println("type:" + bookType.getTypeName());
		System.out.println("================");
	}
	
	public void update(String name,double price,BookType bookType) {
		setName(name);
		setPrice(price);
		setBookType(bookType);
	}
	
	public void update(String name,double price) {
		setName(name);
		setPrice(price);
	}
	
	public static void main(String[] args) {
		
		BookType bookType = new BookType(1, "程式設計");
		
		Book book = new Book();
		book.bookType = bookType;
		book.display();
	}

}
