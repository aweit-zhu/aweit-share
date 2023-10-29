public class BookType {

	private int id;
	
	private String typeName;

	public BookType(int id, String typeName) {
		this.id = id;
		this.typeName = typeName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
