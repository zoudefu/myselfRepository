package ThreadTest;

import java.util.ArrayList;
import java.util.List;

public class SecondThreadTest {
   //解决runable不能有返回返回值的一般方法
	public static void main(String[] args) throws InterruptedException {
		List<Thread> workers=new ArrayList<>(10);
		List<AccumRunnabel> tasks=new ArrayList<>(10);
		Long startDate=System.currentTimeMillis();//程序开始时间
		//新建10个线程，每个线程分别负责累加1~10 ，11~20
		for(int i=0;i<10;i++){
			AccumRunnabel task=new AccumRunnabel(i*10+1, (i+1)*10);
			Thread worker=new Thread(task,"慢速累加器线程"+i);
			tasks.add(task);
			workers.add(worker);
			worker.start();
		}
		int total=0;
		for(int i=0,s=workers.size();i<s;i++){
			workers.get(i).join();//等待线程执行完毕
			total+=tasks.get(i).getResult();
		    }
		Long endDate=System.currentTimeMillis();//程序开始时间
		System.out.println("\n累加结果："+total);
		System.out.println("使用程序执行时间"+String.valueOf(endDate-startDate));
	}
	
	
	static  final  class  AccumRunnabel implements Runnable{
		private final  int begin;
		private final  int end;
		private int result;
		public AccumRunnabel(int  begin,int end){
			this.begin=begin;
			this.end=end;
		}
		@Override
		public void run() {
			result=0;
			for(int i=begin;i<=end;i++){
				result+=i;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("(%s)-运行结束，结果为%d\n", Thread.currentThread().getName(),result);				
			}
		}
		public  int  getResult(){
			return result;  //在runnable的实现类设置一个变量result，在run（）方法里将其改变为我们期待的结果，然后通过一个getResult（）返回变量的值
		}
		
		
	}
	
}
