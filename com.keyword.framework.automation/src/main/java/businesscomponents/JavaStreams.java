package businesscomponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.*;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Streams;

public class JavaStreams {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,3,8,3,5,20,19,29,10);
		list.stream().filter(n -> n%2==0).forEach(System.out::println);
		List<Integer>listElement = list.stream().sorted().collect(Collectors.toList());
		System.out.println(listElement);
		list.stream().sorted().distinct().forEach(System.out::println);
		String str1 = "Hello World", str2="Welcome to hello world";
//		Stream<String> str = Stream.of(str1,str2);
//		List<String>list1 = str.stream();
		//Map<String,Long>map = list.stream().collect(Collectors.groupingBy(Function.(),Collectors.counting()));
		Map<Integer, Long> countMap = list.stream().sorted().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap :: new, Collectors.counting()));
		System.out.println(countMap);
		for(Entry<Integer, Long> entry : countMap.entrySet()) {
			System.out.println("key :"+entry.getKey()+" value : "+entry.getValue());
			
		}
		String str = "Hello world hellow world";
		Map<String, Long>hashmap =Arrays.stream(str.split("\\s+")).collect(Collectors.groupingBy(String::toLowerCase,LinkedHashMap::new,Collectors.counting()));
		
	
		
		for(Entry<String, Long> entry:hashmap.entrySet()) {
			System.out.println("Key string = "+entry.getKey() + " value string = "+entry.getValue());
			
			
		}
		
		
		List<String>list3 = new ArrayList<>();
		list3.add("c++");
		Set<String> set = new HashSet<>();
		set.add("python");
		set.add("java");
		List<String>list4 = new ArrayList(set);
		Set<String> set2 = new HashSet<>(list4);
		System.out.println(set2);
		
		Map<String,Integer> map1 = new HashMap<>();
		for(String str3 : set2) {
			System.out.print("values in set : "+str3);
			map1.put(str3, map1.getOrDefault(str, 0)+1);
		}
		System.out.println(map1.hashCode());
		int i=9;
		System.out.println();
		
//		for(Map.Entry<String, Integer>e : map1.entrySet()) {
//			System.out.println("Key : "+e.getKey()+ " value : "+e.getValue());
//		}
		
		
	}
	

}
