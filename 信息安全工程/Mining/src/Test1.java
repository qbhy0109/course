
public class Test1 {
	public static void main(String[] args) {
		int d = 2;
		String str1 = "00abfcbba3";
		System.out.println(str1.matches(String.format("0{%d}[1-9a-f]{%d}", d,10-d)));
	}
}
