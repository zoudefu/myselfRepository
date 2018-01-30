package designpattern;

public class FactoryPatterDemo {
	
	public static void main(String[] args) {
		//获取Circle的对象 。并调用draw方法
		ShapeFactory shapeFactory=new ShapeFactory();
		Shape shape1=shapeFactory.getShape("CIRCLE");
		shape1.draw();
		Shape shape2=shapeFactory.getShape("RECTANGLE");
		shape2.draw();
		Shape shape3=shapeFactory.getShape("SQUARE");
		shape3.draw();
	}

}
