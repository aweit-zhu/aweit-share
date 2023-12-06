package com.example;

public class DAODemo {
	
	public static void main(String[] args) {

		BookDAO dao = BookFactory.createBookDao();
		
		Book java = new Book("Java",500);
		
		if(java.price > 300) {
			dao.save(java);
		}
	}
}

// 書本
class Book {
	String name;
	int price;
	Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
}

// DAO：資料存取物件
interface BookDAO {
	void save(Book book);
}

//DAO：資料存取物件(存進資料庫)
class BookResposity implements BookDAO {
	@Override
	public void save(Book book) {
		System.out.println("存進資料庫...");
		// 一大段存進資料庫的程式
	}
}

// Factory：統一給予 BookDAO 的地方
class BookFactory {
	public static BookDAO createBookDao() {
		return new BookResposity();
	}
}

