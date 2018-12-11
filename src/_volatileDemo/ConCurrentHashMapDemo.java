package _volatileDemo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConCurrentHashMapDemo {
	private static  ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
//	private static  Map<String, Integer> map = new HashMap<>();
	
	static Lock lock = new ReentrantLock();
	public static void main(String[] args) {
		map.put("count", 0);
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			newCachedThreadPool.submit(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						add();
					}
					
				}
			});
		}
		System.out.println(map.get("count"));
	}
	
	public static void add() {
		lock.lock();
		Integer integer = map.get("count");
		integer++;
		map.put("count", integer);
		lock.unlock();
	}
}
