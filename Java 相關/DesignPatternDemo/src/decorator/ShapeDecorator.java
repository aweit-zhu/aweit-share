package decorator;

/**
 * 抽象裝飾器(Decorator)
 */
public abstract class ShapeDecorator implements Shape {
	
	protected Shape decoratedShape;

	ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	@Override
	public void draw() {
		decoratedShape.draw();
	}

}
