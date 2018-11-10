package _Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(10);
		for (int i = 0; i < 5; i++) {
			ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
			newCachedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						semaphore.acquire(4);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					System.out.println(Thread.currentThread().getName()+" 执行");
					semaphore.release(4);
				}
			});
			
		}
		
	}
}
