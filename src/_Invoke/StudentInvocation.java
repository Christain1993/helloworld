package _Invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StudentInvocation implements InvocationHandler{
	Person s ;
	public Object newInstance(Person s) {
		this.s = s;
		Object newProxyInstance = Proxy.newProxyInstance(s.getClass().getClassLoader(), s.getClass().getInterfaces(),this);
		return newProxyInstance;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		method.invoke(s, args);
		System.out.println("heh");
		return null;
	}
	
	
	public static void main(String[] args) {
		Person newInstance = (Person) new StudentInvocation().newInstance(new Student());
		newInstance.show();
	}

}
