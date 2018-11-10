package _Executors;

import java.util.concurrent.Callable;

public class TestCallable<V> implements Callable<V>{

	@Override
	public V call() {
		throw new RuntimeException("hahahahah");
		
	}

}
