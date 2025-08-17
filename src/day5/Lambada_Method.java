package day5;

interface StrFun{
	String run(String str);
}
public class Lambada_Method {
	public static void askquery(String str,StrFun format) {
		String result = format.run(str);
		System.out.println(result);
	}
	public static void main(String[] args) {
		StrFun exclaim = (s)->s+"!!";
		StrFun query = (s)->s+"??";
		
		askquery("Hello",exclaim);
		askquery("How are you",query);

	}

}
