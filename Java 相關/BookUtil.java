
public class BookUtil {

	private static String from;
	
	static {
		from = "mailfrom@gmail.com.tw";
	}
	
	public static void sendNotification(Book book, String mailTo) {
		
	}
	
	public static void sendNotification(Book book, String from ,String mailTo) {
		
	}
	
	public static String getBookServerUrl(Book book) {
		return "http://";
	}

	public static void main(String[] args) {

		Book book = new Book();

		BookUtil.sendNotification(book, "mailTo@gmail.com.tw");
		
		BookUtil.sendNotification(book, "mailFrom@gmail.com.tw", "mailTo@gmail.com.tw");
		
		String url = BookUtil.getBookServerUrl(book);
		
	}

}
