package decorator;

/**
 * 具體組件(Concrete Component)
 */
public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape: Rectangle");
	}

}
