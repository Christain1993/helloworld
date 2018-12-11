package _CollectionsTest;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		testmap(map);
		System.out.println(map);
	}
	public static void testmap(Map<String,Object> map) {
		map.put("1", 1);
	}
}
