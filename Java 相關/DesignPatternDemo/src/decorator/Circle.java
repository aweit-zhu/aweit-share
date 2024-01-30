package decorator;

/**
 * 具體組件(Concrete Component)
 */
public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape: Circle");
	}

}
