import java.security.MessageDigest;
import java.math.BigInteger;
import java.util.Random;

public class DigMine {
	public static void main(String[] args) throws Exception{
		Mining mining = new Mining();	// 实例化mining对象
		int loop = 3;	//每次难度循环次数，即符合条件的整数个数
		for(int d=1;d<6;++d) {			// 挖矿难度 d=1，2，3，4，5
			System.out.println("  难度 d: "+d+"\t成功挖矿次数: "+loop); 
			long cost = 0;	// 总共挖矿用时
			int count=0;	// 总共挖矿次数
			for(int i=0;i<loop;++i) {	// 挖矿成功次数loop
				boolean flag = false;
				long time1 = System.currentTimeMillis();	//挖矿开始
				while(!flag) {			// 挖矿成功一次时停止
					String str = mining.getHashCode();
					flag = mining.digSuccess(str,d);
					count++;
				}
				long time2 = System.currentTimeMillis();	//挖矿结束
				cost += time2-time1;
			}
			System.out.println("    次数: "+count+"\t\t"+"平均时长:"+cost/loop+"ms");
			System.out.println();
		}	
	}
}

class Mining{
	private String num="";
	private String hashstr="";
	private String hashcode="";
	
	public String getHashCode() throws Exception{
		Random r= new Random();
		String str = Integer.toString(r.nextInt(Integer.MAX_VALUE));
		this.num = str;
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(this.num.getBytes("UTF-8"));
		byte[] result = md.digest();
		this.hashstr = new BigInteger(1,result).toString(16);
		this.hashcode = String.format("%064x", new BigInteger(1, result));
		return this.hashstr;
	}
	
	public boolean digSuccess(String s,int d) {
		if(s.length()+d==64) 
			printResult();
		return s.length()+d==64;
	}

	public void printResult() {
		System.out.println(String.format("随机整数: %s", this.num));
		System.out.println(String.format("  哈希值: %s", this.hashcode));
	}
}

////正则表达式判断
//public boolean judgeOK2(String s,int d) {
//	if(s.matches(String.format("0{%d}[1-9a-f]{%d}", d,64-d))) {
//		printResult();
//		return true;
//	}else {
//		return false;
//	}
//}

