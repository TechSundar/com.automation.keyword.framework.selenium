package businesscomponents;

import java.util.HashMap;
import java.util.Map;

import supportlibrariesbackend.ExcelDataManagerSS;

public class Helper {
	public static void main(String args[]) {
		String sentence = "This is the book and it has the book this";
		String str[] = sentence.toLowerCase().split(" ");
		Map<String, Integer>map = new HashMap<>();
		for(String word : str) {
			map.put(word,map.getOrDefault(word, 0)+1);
		}
		for(Map.Entry<String, Integer>conf :map.entrySet()) {
			System.out.println("Key "+conf.getKey()+" value : "+conf.getValue());
			
		}
//		ExcelDataManagerSS.initialize_relativePath();	
//		Map<String, String>config = ExcelDataManagerSS.getRunInfo();
//		for(Map.Entry<String, String>entry : config.entrySet()) {
//			System.out.println(entry.getKey() + " :  "+entry.getValue());
//		}
		
		
	}

}
