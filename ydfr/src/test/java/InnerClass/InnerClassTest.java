package InnerClass;

public class InnerClassTest {
		private static int size;
       //内部类Inner的声明
		public class Inner{
			private int size;
			@SuppressWarnings("static-access")
			public void doStuff(int size){
				size++;//存取局部变量
				 this.size++;//存取其内部类的成员变量
				 InnerClassTest.this.size++;//存取其外部类的成员变量
				 System.out.println("存取局部变量size"+size);
				 System.out.println("存取内部类的成员变量this.size"+this.size);
				 System.out.println("存取其外部类的成员变量Innerclasstest"
				 		+ ""+InnerClassTest.this.size);
			}
		}
		
		//类Inner中定了的实例方法 TestInner（）方法
		public void testInner(){
			Inner inner=new  Inner();
			inner.doStuff(5);
		}
		public static void main(String[] args) {
			InnerClassTest test=new InnerClassTest();
			test.testInner();
			
		}
}
