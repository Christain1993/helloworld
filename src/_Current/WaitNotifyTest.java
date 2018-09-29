package _Current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// wait notify只能配合synchronized 使用
public class WaitNotifyTest {
	public static volatile boolean condition = false;
	public static final Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		testnotifyall();
	}
	
	public static void testnotifyall() throws InterruptedException {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			newFixedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					synchronized (lock) {
						while (!condition) {
							try {
								System.out.println("线程等待");
								lock.wait();
								System.out.println("线程唤醒");
							} catch (InterruptedException e) {
							}
						}
						System.out.println(Thread.currentThread().getName() + "   执行");
					}
				}
			});
		}
		
		TimeUnit.SECONDS.sleep(1);
		condition = true;
		synchronized (lock) {
			// notifyAll会唤醒对象锁上等待的所有线程
			lock.notifyAll();
		}
		System.out.println("改变变量");
	}

	public static void testnotify() throws InterruptedException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock) {
					while (!condition) {
						try {
							System.out.println("线程等待");
							lock.wait();
							System.out.println("线程唤醒");
						} catch (InterruptedException e) {
						}
					}
					System.out.println(Thread.currentThread().getName() + "   执行");
				}

			}
		}).start();

		TimeUnit.SECONDS.sleep(1);
		condition = true;
		synchronized (lock) {
			// 只能在同步代码块中进行notify操作,被唤醒的线程从等待时执行的代码开始执行;
			lock.notify();
		}
		System.out.println("改变变量");
	}
}
