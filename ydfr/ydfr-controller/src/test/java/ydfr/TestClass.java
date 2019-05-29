package ydfr;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date crtTime = new Date();
		long crt = crtTime.getTime();
		Timer timer = new Timer();

		// 在指定时间执行
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("【任务一】");
			}
		}, new Date(crt - 1000));

		// schedule和scheduleAtFixedRate
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("【任务二】");
			}
		}, new Date(crt - 10 * 1000), 1000);

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("【任务三】");
			}
		}, new Date(crt - 10 * 1000), 1000);

		// schedule和scheduleAtFixedRate
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("【任务四】");
			}
		}, new Date(crt + 2 * 1000), 1000);

		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				System.out.println("【任务五】");
			}
		}, new Date(crt + 2 * 1000), 1000);
	}

}
