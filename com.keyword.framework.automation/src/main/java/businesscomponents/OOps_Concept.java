package businesscomponents;

public class OOps_Concept implements Functional_Interface{
	
	
	public static void longestSubString() {
		String str = "malayalamalayalam", resultOdd="", resultEven="";
		String finalresult = "";
		
		for(int i=0;i<str.length();i++) {
			
			
			resultOdd = expand(str,i,i);
			resultEven= expand(str,i,i+1);
			
			if(resultOdd.length()>resultEven.length()) {	
				String current = resultOdd;
				if(finalresult.length()<current.length()) {
					finalresult=current;
				}
							
				//System.out.println("The longest palindromic substring odd "+resultOdd);
			}
			else {
				String current = resultEven;
				if(finalresult.length()<current.length()) {
					finalresult=current;
				}
				//System.out.println("The longest palindromic substring even "+resultEven);
			}
			
		}
		System.out.println("Longest substring is "+ finalresult + " And its length is "+finalresult.length());
		
	}
	public static String expand(String word, int L, int R) {
		while(L>=0 && R<word.length() && word.charAt(L)==word.charAt(R)) {
			L--;
			R++;
		}
		return word.substring(L+1, R);
	}
	
	
	
	public void run() {
		System.out.println("In class");
	}
	static void method(){
		System.out.println("In static");
	}
	{
		System.out.println("Anonmyous method");
	}
	public static void main(String[] args) {
//		try {
//			Class.forName("OOps_Concept");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		OOps_Concept.method();
		Functional_Interface fn = new Functional_Interface() {
			
			public void run() {
				String str = "Hello world";
				System.out.println(str.hashCode());
				str="hello";
				System.out.println("After modify "+str.hashCode());
				String str1 = "Hello world";
				
				System.out.println("str1 "+str1.hashCode());
				String str2 = new StringBuilder("Hello").reverse().toString();
				System.out.println("str2 "+str2);
				System.out.println("In main");
			}
			};
			fn.run();
			OOps_Concept obj = new OOps_Concept();
			obj.run();
			OOps_Concept.longestSubString();
	}
}
	
	

