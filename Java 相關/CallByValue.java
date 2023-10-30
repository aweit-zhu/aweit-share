class People {
	String name;
	People(String name){this.name = name;}
	public String getName() {return this.name;}
}

public class CallByValue {
	public static void renameI(People people) {
		people = new People("Jackson");
		System.out.println("renameI: "+people.getName());
	}
	public static void renameII(People people) {
		people.name = "Jackson";
		System.out.println("renameII: "+people.getName());
	}
	public static void main(String[] args) {
		People people = new People("Jack");
		System.out.println("1.main: "+people.getName());
		
		renameI(people);
		System.out.println("2.main: "+people.getName());
		
		renameII(people);
		System.out.println("3.main: "+people.getName());
	}
}


