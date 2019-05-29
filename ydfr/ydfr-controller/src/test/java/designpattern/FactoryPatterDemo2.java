package designpattern;

public class FactoryPatterDemo2 {
	public static void main(String[] args) {
		
		Rectangle rectangle=(Rectangle)ShapeFactory2.getClass(Rectangle.class);
		rectangle.draw();
	}

}
