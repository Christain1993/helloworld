package _Queue;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import _HttpClient.HttpclientTest;

public class BlockQueueTest {

	static BlockingQueue<Object> queue = new ArrayBlockingQueue<>(100);
	public static Integer count = 0;
	public static  Boolean flag = true;

	public static void main(String[] args) {
		ExecutorService exes = Executors.newCachedThreadPool();
		for (int i = 0; i < 300; i++) {
			exes.submit(new Runnable() {

				@Override
				public void run() {
					for (int i = 10; i < 1 << 30; i++) {
						if (flag) {
							
//								queue.put(count++);
								String name = Thread.currentThread().getName();
								System.out.println("provider thread name " + name);
								String doGet = HttpclientTest.doGet("http://www.ctrip.com/", new HashMap<>());
								System.out.println(doGet);
//								 if(count.equals(Integer.valueOf(100000))) { flag = false; }
								 
						
						}

					}
				}

			});
		}
		exes.submit(new Runnable() {
			@Override
			public void run() {
				try {
					Integer take = (Integer) queue.take();
					while (take != null) {
						// Thread.sleep(30);
						System.out.println(take);
						System.out.println("队列的长度" + queue.size());
						String name = Thread.currentThread().getName();
//						System.out.println("consumer thread name " + name);
						take = (Integer) queue.take();
						/*
						 * if (take.equals(Integer.valueOf(10000))) { flag = false; }
						 */
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

	}

}
