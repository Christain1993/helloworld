package _Executors;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory{
	private UncaughtExceptionHandler handler ;
	
	
	public MyThreadFactory(UncaughtExceptionHandler handler) {
		super();
		this.handler = handler;
	}

	@Override
	public Thread newThread(Runnable var1) {
		Thread thread = new Thread(var1);
		thread.setUncaughtExceptionHandler(handler);
		return thread;
	}

}
