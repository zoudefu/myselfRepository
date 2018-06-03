
public class ExcptionTest {
	public static void main(String[] args) {
		ExcptionTest excptionTest=new ExcptionTest();
		System.out.println(excptionTest.testException());
	}
	public String testException(){

		try {
			System.out.println("start try");
			int[] a={2};
			for(int i=0;i<2;i++){
				System.out.println(a[i]);
			}
			System.out.println("try end");
			return "return of  try  not finally";
			} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("arrayIndexoutOfBoundsException");
		}catch(NullPointerException e){
			System.out.println("nullPointerException");
			return "return in  catch";
		}finally {
			System.out.println("finally start try");
			int[] a={2};
			for(int i=0;i<2;i++){
				System.out.println(a[i]);
			}
			System.out.println("finallyend end end ");
			System.out.println("finally");
			return "return of finally";
		}
	
		
	}
	

}
