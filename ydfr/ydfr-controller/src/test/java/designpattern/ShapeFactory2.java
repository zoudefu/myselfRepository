package designpattern;


public class ShapeFactory2 {
 public static Object  getClass(Class<? extends Shape> clazz){
	 Object object=null;
	 try {
		 //利用java的反射机制获得实体类
		object=Class.forName(clazz.getName()).newInstance();
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	 return object;
	 
 }
}
