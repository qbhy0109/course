import java.security.MessageDigest;
import java.math.BigInteger;
import java.util.Random;

public class MiningAlgorithm {
	public static void main(String[] args) throws Exception{
		long time = 0;
		int d=1;
		for(;d<6;++d) {
			System.out.println("d = "+d);
			for(int i=0;i<3;++i) {
				boolean flag = false;
				long time1 = System.currentTimeMillis();
				while(!flag) {
					String[] str1 = getHashCode();
					flag = judgeOK(str1,d);
				}
				long time2 = System.currentTimeMillis();
				time += time2-time1;
			}
			System.out.println("average time: "+time/3+"ms");
		}
	}
	
	public static String[] getHashCode() throws Exception{
		Random r = new Random();
		String str = Integer.toString(r.nextInt(Integer.MAX_VALUE));
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes("UTF-8"));
		byte[] result = md.digest();
		String code = new BigInteger(1,result).toString(16);
		String code1 = String.format("%064x", new BigInteger(1,result));
		String[] s = {code,str,code1};
		return s;

	}
	
	public static boolean judgeOK(String[] s,int d) {
		if(s[0].length()+d==64) {
			System.out.print("random integer number:");
			System.out.println(s[1]);
			System.out.print("hashcode:");
			System.out.println(s[2]);
		}
		return s[0].length()+d==64;
	}
}

