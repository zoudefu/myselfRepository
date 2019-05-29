package ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.shiro.subject.ExecutionException;

public class FutureCancalTestFirst {
        //future 的 cancel取消future里的线程  ，future里有个执行3秒的线程  但是两秒被取消了 所以输出结果为”任务被取消“ 
	    public static void main(String[] args) throws Exception {
	        ExecutorService threadPool = Executors.newSingleThreadExecutor();

	        SimpleTask task = new SimpleTask(3_000); // task 需要运行 3 秒
	        Future<Double> future = threadPool.submit(task);
	        threadPool.shutdown(); // 发送关闭线程池的指令
	        cancelTask(future,2_000);//在2秒之后取消该任务
	        try{
	        	double time=future.get();
	        	System.out.println("任务运行时间:"+String.valueOf(time/1E9));
	        }catch(CancellationException ex){
	        	System.err.println("任务被取消");
	        }catch (InterruptedException ex) {
				System.err.println("当前线程被中断");
			}catch (ExecutionException ex) {
				System.err.println("任务执行出错");
			}

	    }

	    private static final class SimpleTask implements Callable<Double> {

	        private final int sleepTime; // ms

	        public SimpleTask(int sleepTime) {
	            this.sleepTime = sleepTime;
	        }

	        @Override
	        public Double call() throws Exception {
	            double begin = System.nanoTime();
	            Thread.sleep(sleepTime);
	            double end = System.nanoTime();
	            double time = (end - begin) / 1E9;
	            return time; // 返回任务运行的时间，以 秒 计
	        }

	    }
	    private  static  void  cancelTask(final Future<?> future, final int delay){
	    Runnable cancellation=new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(delay);
					future.cancel(true);//取消与future关联的正在运行的任务
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};	
	    new Thread(cancellation).start();
	    }
}
 