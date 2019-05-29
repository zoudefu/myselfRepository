package  ThreadTest;


public class FirstThreadTest {
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable=new Runnable() {
			@Override
			public void run() {
				System.out.println("线程启动");
				//耗时操作
				System.out.println("线程结束");
			}
		};
		Thread thread=new  Thread(runnable);//创建线程，runnable作为线程要执行的任务（载体）
		thread.start();//启动线程
        thread.join();//等待线程执行完毕(确定一个线程完毕才能执行下一个线程)
	}

}
