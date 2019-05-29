package ThreadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockThreadTest {
	
	public static void main(String[] args) {
		Lock lock =new ReentrantLock();	
		LockThreadTest testThread=new LockThreadTest();
		Consumer consumer =testThread.new Consumer(lock);
		Producer producer=testThread.new Producer(lock);
		new Thread(consumer).start();
		new Thread(producer).start();
	}
	// 消费者
	class Consumer implements Runnable {

		private Lock lock;

		public Consumer(Lock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			int count = 10;
			while (count > 0) {
				try {
					lock.lock();
					count--;
					System.out.println("消费者");
				} finally {
					lock.unlock();// 主动释放锁
					try {
						Thread.sleep(97L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}

	}
	//生产者
	class Producer implements Runnable{
		
		private Lock lock;
	

		public Producer(Lock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			int count = 10;
			while (count > 0) {
				try {
					lock.lock();
					count--;
					System.out.println("生产者");
				} finally {
					lock.unlock();// 主动释放锁
					try {
						Thread.sleep(97L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
		
	}

}
