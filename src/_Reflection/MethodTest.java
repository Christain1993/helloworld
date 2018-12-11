package _Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {
	public static void main(String[] args) throws Exception, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Method method = Parents.class.getMethod("take", String.class);
//		Object invoke = method.invoke(new Son(), "hahsdasdsa");
//		Object invoke2 = method.invoke(new Girl(), "3232");
//		System.out.println(invoke);
//		System.out.println(invoke2);
		
//		Method method2 = MethodTest.class.getMethod("take", String.class);
//		method2.invoke(new Son(), "hahsdasdsa");
//		method2.invoke(new Girl(), "3232");
		
		Field field = Humman.class.getField("age");
		Humman son = new Son();
		son.age = "12";
		Girl girl = new Girl();
		girl.age = "33";
		Object object = field.get(son);
		Object object2 = field.get(girl);
		System.out.println(object);
		System.out.println(object2);
		
	}
	public void take(String str) {
		
	}
}
