import java.security.MessageDigest;
import java.math.BigInteger;
import java.util.Random;

public class MiningAlgorithm {
	public static void main(String[] args) throws Exception{
		long time = 0;
		for(int i=0;i<3;++i) {
			boolean flag = false;
			long time1 = System.currentTimeMillis();
			while(!flag) {
				String str1 = getHashCode();
				flag = judgeOK(str1,5);
			}
			long time2 = System.currentTimeMillis();
			time += time2-time1;
		}
		System.out.println("average time: "+time+"ms");
	}
	
	public static String getHashCode() throws Exception{
		Random r = new Random();
		String str = Integer.toString(r.nextInt(Integer.MAX_VALUE));
//		System.out.println(str);
		
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

