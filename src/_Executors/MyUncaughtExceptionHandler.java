package _Executors;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("catched ");
	}

}
