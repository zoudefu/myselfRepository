package ThreadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
public class ThreeThreadTest {
	//解决runable没有返回值和抛出异常的功能可以看到使用 Callable<V> + FutureTask<V> 
	//的程序代码要比 Runnable 的代码更简洁和方便 —— 当需要线程执行完成返回结果时（或者任务需要抛出异常），
	//Callable<V> 是优先于 Runnable 的选择
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("使用 Callable获得返回结果：");
		List<FutureTask<Integer>> futureTasks=new ArrayList<FutureTask<Integer>>(10);
		//创建10个线程，每个线程分别扶着累加1~10，11~20.....
		for(int i=0;i<10;i++){
			AccumCallable task=new AccumCallable(i*10+1, (i+1)*10);
			FutureTask<Integer> futureTask=new FutureTask<>(task);
			futureTasks.add(futureTask);
			Thread worker= new Thread(futureTask,"慢速累加器线程"+i);
		    worker.start();			
		}
		int  total=0;
		for(FutureTask<Integer>  futrueTask:futureTasks){
			total+=futrueTask.get();//方法会阻塞知道获得结果
		}
		 System.out.println("累加的结果: " + total);
	}
  static final class  AccumCallable implements Callable<Integer>{
 
		private final int begin;
		private final int end;

		public AccumCallable(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int  result =0;
		for(int i=begin;i<=end;i++){
		result+=i;
		Thread.sleep(100);
		}
		System.out.printf("(%s)-运行结束，结果为%d\n",Thread.currentThread().getName(),result);
		return result;
	}
  }
}
