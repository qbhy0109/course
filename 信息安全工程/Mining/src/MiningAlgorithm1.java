import java.security.MessageDigest;
import java.math.BigInteger;
import java.util.Random;

public class MiningAlgorithm1 {
	public static void main(String[] args) throws Exception{
		Mining mining = new Mining();
		long time = 0;
		int d = 1;
		int loop = 3;
		for(int i=0;i<loop;++i) {
			boolean flag = false;
			long time1 = System.currentTimeMillis();
			while(!flag) {
				String str = mining.getHashCode();
				flag = mining.judgeOK(str,d);
			}
			long time2 = System.currentTimeMillis();
			time += time2-time1;
		}
		System.out.println("average time:"+time/loop+"ms");
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
}

class Mining{
//	private int d;
	private String num="";
	private String hashstr="";
	private String hashcode="";
	
//	public Mining(int d) {
//		this.d = d;
//	}
	
	public String getHashCode() throws Exception{
		Random r= new Random();
		String str = Integer.toString(r.nextInt(Integer.MAX_VALUE));
		this.num = str;
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes("UTF-8"));
		byte[] result = md.digest();
		this.hashstr = new BigInteger(1,result).toString(16);
		this.hashcode = String.format("%064x", new BigInteger(1, result));
		return this.hashcode;
	}
	
	public boolean judgeOK2(String s,int d) {
		if(s.length()+d==64) 
			printResult();
		return s.length()+d==64;
	}
	public boolean judgeOK(String s,int d) {
		if(s.matches(String.format("0{%d}[1-9a-f]{%d}", d,64-d))) {
			printResult();
			return true;
		}else {
			return false;
		}
	}
	
	public void printResult() {
		System.out.println(String.format("random integer:%s", this.num));
		System.out.println(String.format("hashcode:%s", this.hashcode));
	}
	
	
}
