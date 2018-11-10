package _Thread;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Human {
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Thread() {

				@Override
				public void run() {
					try {
						Human.eat();
					} catch (Exception e) {
					}
					super.run();
				}
				
			}.start();
		}
		new Thread() {

			@Override
			public void run() {
				try {
					new Human().work();
				} catch (Exception e) {
				}
				super.run();
			}
		}.start();
	}
	
	public synchronized static void eat() throws Exception { 
		Thread currentThread = Thread.currentThread();
		
		System.out.println("开始吃饭: "+currentThread.getName());
		currentThread.sleep(3000);
		System.out.println("吃饭结束: "+currentThread.getName());
	}
	
	public synchronized void work() throws Exception {
		Thread currentThread = Thread.currentThread();
		System.out.println("工作: "+currentThread.getName());
		currentThread.sleep(3000);
		System.out.println("工作: "+currentThread.getName());
	}
}
