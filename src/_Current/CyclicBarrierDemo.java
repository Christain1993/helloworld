package _Current;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
	
	public static CyclicBarrier cb3 = new CyclicBarrier(2);
	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier cb = new CyclicBarrier(4,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("开始比赛");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		});
		
		CyclicBarrier cb2 = new CyclicBarrier(4,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("比赛结束");
				try {
					Thread.sleep(1000);
					cb3.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 4; i++) {
			newCachedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+" 选手已经准备好 !!");
					try {
						cb.await();
					} catch (Exception e) {
					}
					System.out.println(Thread.currentThread().getName()+" 选手跑到了终点 !!");
					try {
						cb2.await();
					} catch (Exception e) {
					}
				}
			});
		}
		cb3.await();
		System.out.println("==========准备下一次比赛==========");
		Thread.sleep(2000);
		
		
		for (int i = 0; i < 4; i++) {
			newCachedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+" 选手已经准备好 !!");
					try {
						cb.await();
					} catch (Exception e) {
					}
					System.out.println(Thread.currentThread().getName()+" 选手跑到了终点 !!");
					try {
						cb2.await();
					} catch (Exception e) {
					}
				}
			});
		}
		
	}
}
