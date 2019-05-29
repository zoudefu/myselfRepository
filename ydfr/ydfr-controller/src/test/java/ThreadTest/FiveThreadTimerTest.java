package ThreadTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class FiveThreadTimerTest {
	public static void main(String[] args) {
	ScheduledExecutorService timer=Executors.newSingleThreadScheduledExecutor();
	TimerTask timerTask=new TimerTask(2000);//任务需要2秒才能执行完毕
	System.out.println("起始时间：" + new SimpleDateFormat().format(new Date()));
    //延时1秒后，按3秒的周期执行任务
	timer.scheduleAtFixedRate(timerTask, 1000, 3000, TimeUnit.MILLISECONDS);
	}
	
	
 private  static class TimerTask implements Runnable{
	 
	 private final  int  sleepTime;
	 private final  SimpleDateFormat dateFormat;

	public TimerTask(int sleepTime) {
		this.sleepTime = sleepTime;
		this.dateFormat = new  SimpleDateFormat("HH:mm:ss");
	}

	@Override
	public void run() {
		System.out.println("任务开始，当前时间："+dateFormat.format(new Date()));
		
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("任务结束，当前时间"+dateFormat.format(new Date()));
	}
	 
 }
}
