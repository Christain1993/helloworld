package _Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExceptionRunnable implements Runnable{

	@Override
	public void run() {
		throw new RuntimeException();
	}
	public static void main(String[] args) {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		try {
			Future<?> submit = newCachedThreadPool.submit(new ExceptionRunnable());
			Object object = submit.get();
			System.out.println(object);
		} catch (Exception e) {
			System.out.println("catched exception!");
		}
		
		
	}

}
