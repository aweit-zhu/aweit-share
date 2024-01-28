package decorator;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
		
		Shape redCircle = new RedShapeDecorator(new Circle());

		System.out.println("Circle of red border");
		redCircle.draw();
		
		/**
		 * Circle of red border
		 * Shape: Circle
		 * Border Color: Red
		 */
	}

}
