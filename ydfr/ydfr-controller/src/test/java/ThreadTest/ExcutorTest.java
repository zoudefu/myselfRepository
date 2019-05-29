package ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExcutorTest {
	private static Integer pages=1; //网页数量
	private static boolean exeFlag=true;//执行标识
	public static void main(String[] args) {
	//创建ExecutorService 连接池创建固定的10个初始线程
		ExecutorService executorService=Executors.newFixedThreadPool(10);
		while(exeFlag){
			if(pages<100){
				executorService.execute(new Runnable(){

					@Override
					public void run() {
						System.out.println("爬取了第"+pages+"页数据");
						pages++;
					}
				});
			}else{
				if(((ThreadPoolExecutor)executorService).getActiveCount()==0){
					executorService.shutdown();//结束所有的线程
					exeFlag=false;
					System.out.println("爬虫任务已经完成");
				}
			}
			try {
				Thread.sleep(100);//线程休息0.1秒 如果不用线程休息 线程会执行的很快 不走eles的方法 加锁影响效率所以最好是用thread.sleep
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
