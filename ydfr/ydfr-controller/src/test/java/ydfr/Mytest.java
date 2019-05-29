package ydfr;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Mytest {
	public static void main(String[] args)
	{
		try {
			//Calendar cal = calendar();
			// 测试Class.forName()内的路径包括包+文件名
			Class<?> testTypeForName = Class.forName("ydfr.TestClassType");
			System.out.println("testForName---" + testTypeForName);
			// 测试类名.class
			Class<TestClassType> TestClassType = TestClassType.class;
			System.out.println("TestClassType---" + TestClassType);
			// 测试Object.getClass()
			TestClassType testGetClass = new TestClassType();
			System.out.println("testGetClass---" + testGetClass.getClass());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public static Calendar calendar() {
	        Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
	        System.out.println(Calendar.DAY_OF_WEEK);
	        System.out.println(Calendar.MONDAY);
	        return cal;
	    }
}
 class TestClassType{  
	  
	// 构造函数
	public TestClassType() {
		System.out.println("----构造函数---");
	}
	// 静态的参数初始化
	static {
		System.out.println("---静态的参数初始化---");
	}
	// 非静态的参数初始化
	{
		System.out.println("----非静态的参数初始化---");
	} 
}
