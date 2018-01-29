package designpattern;

public class ShapeFactory {
	
	public Shape getShape(String shapeType){
		if(shapeType==null){
			return null;
		}
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new Cricle();
			
		}else if(shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		}else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
        return  null;  		
	}
	

}
