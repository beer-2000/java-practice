package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Practice {
	public static void main(String[] args) {
		System.out.println("test");
		List<String> list = new ArrayList<>(Arrays.asList("one", "two"));
		List<String> list2 = Arrays.asList("one", "two");
		String[] stringArray = list.stream()
			.map(character -> {
				System.out.println(character);
				return String.valueOf(character);
			})
			.toArray(a -> new String[a]);
		String[] stringArray2 = list.stream()
			.map(character -> String.valueOf(character))
			.toArray(a -> new String[2]);
			// .toArray(String[]::new);
		// stringArray.stream().map();
		System.out.println(stringArray2[0]);
		System.out.println(stringArray2[1]);
		// List a = List;
		Stream<String> stream = list.stream();

		Set<String> set = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();

		Integer[] integerArray = {1, 2, 3};
		int[] intArray = {1, 2, 3};
		List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));
		List<Integer> list4 = new ArrayList<>(Arrays.asList(integerArray));
		list3.stream().forEach(a -> {
			try {
				checkIsOne(a);
			} catch (Exception e) {
				System.out.println(e);
			}
		});
		list3.stream().forEach(a -> {
			try {
				checkIsOne(a);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});

	}
	static void checkIsOne(int number) throws Exception{

		if (number == 1) {
			throw new Exception("oh no");
		}

		System.out.println(number);
	}

}
