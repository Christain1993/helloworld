package _Executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ExecutorTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyThreadFactory factory = new MyThreadFactory(new MyUncaughtExceptionHandler());
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(100, factory);
		List<Future<Object>> result = new ArrayList<Future<Object>>();
		for (int i = 0; i < 10; i++) {
			Future<Object> submit = newFixedThreadPool.submit(new TestCallable<Object>());
			result.add(submit);
			newFixedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
//					throw new RuntimeException();
				}
			});
		}
		for (Future<Object> future : result) {
			try {
				Object object = future.get();
			} catch (Exception e) {
//				e.printStackTrace();
				StackTraceElement[] stackTrace = e.getStackTrace();
				for (StackTraceElement stackTraceElement : stackTrace) {
				}
			}
			
		}
	}
}
