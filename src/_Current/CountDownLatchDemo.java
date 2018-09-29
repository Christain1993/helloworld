package _Current;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
	public static void main(String[] args) {
		
		//所有线程阻塞，然后统一开始
		CountDownLatch begin = new CountDownLatch(1);
		
		//主线程阻塞，直到所有分线程执行完毕
		CountDownLatch end = new CountDownLatch(5);
		
		for(int i = 0; i < 5; i++){
			ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
			newCachedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						begin.await();
						System.out.println(Thread.currentThread().getName() + " 起跑 " + System.currentTimeMillis());
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + " 到达终点 " + System.currentTimeMillis());
						end.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		try {
			System.out.println("比赛开始");
			Thread.sleep(1000);
			begin.countDown();
			end.await();
			System.out.println("停止比赛");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
