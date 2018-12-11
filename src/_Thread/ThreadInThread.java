package _Thread;

import java.util.concurrent.TimeUnit;

public class ThreadInThread {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				new Thread() {
					public void run() {
//						for (int i = 0; i < 1000; i++) {
//							System.out.println(i);
//						}
						try {
							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e) {
						}
						System.out.println("121212323");
					}
				}.start();
				System.out.println("done");
			}
		}.start();
	}
}
