//import java.security.MessageDigest;
//import java.math.BigInteger;
//import java.util.Random;
//
//public class Mining {
//	public static void main(String[] args) throws Exception{
//		long time = 0;
//		for(int i=0;i<3;++i) {
//			boolean flag = false;
//			long time1 = System.currentTimeMillis();
//			while(!flag) {
//				String str1 = getHashCode();
//				flag = judgeOK(str1,1);
//			}
//			long time2 = System.currentTimeMillis();
//			time += time2-time1;
//		}
//		System.out.println("average time: "+time+"ms");
//	}
//	
//	public static String getHashCode() throws Exception{
//		Random r = new Random();
//		String str = Integer.toString(r.nextInt(Integer.MAX_VALUE));
//		
//		MessageDigest md = MessageDigest.getInstance("SHA-256");
//		md.update(str.getBytes("UTF-8"));
//		byte[] result = md.digest();
//		String code1 = String.format("%064x", new BigInteger(1,result));
////		System.out.println(code1);
//		return code1;
//	}
//	
//	public static boolean judgeOK(String code, int d) {
//		return code.matches(String.format("0{%d}[1-9a-f]{%d}", d,64-d));
//	}
//}
//
