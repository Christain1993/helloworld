package _Current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AwaitLockTest {
	// 这个condition一定是 volatile 修饰的 , 因为要保证condition的可见性
	public volatile static int condition = 0 ;
	public static void main(String[] args) throws InterruptedException {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		newCachedThreadPool.execute(new Runnable() {
			
			@Override
			public void run() {
				while(!(condition ==1) ) {
				}
				System.out.println(Thread.currentThread().getName()+ "    hahahahah");
				
			}
		});
		TimeUnit.SECONDS.sleep(1);
		condition=1;
	}
}
