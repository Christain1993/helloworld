package _CommonTest;

import java.lang.reflect.Method;

public class TestTimeUtil {
	public static void showtime(Class clazz ,Method method) throws Exception {
		long start = System.currentTimeMillis();
		method.invoke(clazz, null);
		long end = System.currentTimeMillis();
		System.out.println("总耗时"+(end-start));
	}
}
