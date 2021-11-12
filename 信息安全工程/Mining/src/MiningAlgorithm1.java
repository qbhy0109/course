import java.security.MessageDigest;
import java.math.BigInteger;
import java.util.Random;

public class MiningAlgorithm1 {
	public static void main(String[] args) throws Exception{
		Mining mining = new Mining(3);
		long time = 0;
		for(int i=0;i<10;++i) {
			boolean flag = false;
			long time1 = System.currentTimeMillis();
			while(!flag) {
//				String str1 = getHashCode();
//				flag = judgeOK(str1,5);
				String str = mining.getHashCode();
				flag = mining.judgeOK(str);
			}
			long time2 = System.currentTimeMillis();
			time += time2-time1;
		}
		System.out.println(time);
	}
	
	public static String getHashCode() throws Exception{
		Random r = new Random();
		String str = Integer.toString(r.nextInt(Integer.MAX_VALUE));
		System.out.println(str);
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes("UTF-8"));
		byte[] result = md.digest();
//		String code = new BigInteger(1,result).toString(16);
		String code1 = String.format("%064x", new BigInteger(1,result));
		return code1;
	}
	
	public static boolean judgeOK(String code, int d) {
		char ch0 = code.charAt(0);
		char ch1 = code.charAt(1);
		switch(d) {
		case 1:
			if(ch0>'3'&&ch0<'8') {
				System.out.println(code);
				return true;
			}
		case 2:
			if(ch0>'1'&&ch0<'4') {
				System.out.println(code);
				return true;
			}
		case 3:
			if(ch0=='1') {
				System.out.println(code);
				return true;
			}
		case 4:
			if(ch0=='0'&&ch1>'3'&&ch1<'8') {
				System.out.println(code);
				return true;
			}
		case 5:
			if(ch0=='0'&&ch1>'1'&&ch1<'4') {
				System.out.println(code);
				return true;
			}
		default:
			return false;
		}
	}
}

class Mining{
//	private Random r= new Random();
//	private String str= Integer.toString(this.r.nextInt(Integer.MAX_VALUE));
	private int d;
	private String num="";
	private String hashcode="";
	
	public Mining(int d) {
		this.d = d;
	}
	
	public String getHashCode() throws Exception{
		Random r= new Random();
		String str = Integer.toString(r.nextInt(Integer.MAX_VALUE));
		this.num = str;
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes("UTF-8"));
//		byte[] result = md.digest();
		this.hashcode = String.format("%064x", new BigInteger(1, md.digest()));
		return this.hashcode;
	}
	
	public boolean judgeOK(String code) {
//		System.out.println(code);
		String str1 = Integer.toBinaryString(code.charAt(0)+code.charAt(1));
//		String str2 = str1.split("1")[0];
//		System.out.println(str1);
		if(8-str1.length()==this.d) {
			printNum();
			return true;
		}else {
			return false;
		}
	}
	
	public void printNum() {
		System.out.println(String.format("random integer:%s", this.num));
		System.out.println(String.format("random integer:%s", this.hashcode));
	}
	
	
}
