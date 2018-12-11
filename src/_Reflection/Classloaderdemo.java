package _Reflection;

public class Classloaderdemo {
	public static void main(String[] args) throws ClassNotFoundException {
		String className = new Throwable().getStackTrace()[0].getClassName();
		System.out.println(className);
		ClassLoader loader = new Classloaderdemo().getClass().getClassLoader();
		System.out.println(loader);
		Class<?> loadClass = loader.loadClass(className);
		String name = loadClass.getName();
		System.out.println(name);
		
	}
}
