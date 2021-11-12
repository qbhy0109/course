import java.math.BigInteger;
import java.security.MessageDigest;

public class Test {
	public static void main(String[] args) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update("55".getBytes("UTF-8"));
		byte[] result = md.digest();
		System.out.println(result);
		int time=0;
		for(byte re:result) {
			System.out.print(re);
			time++;
		}
		System.out.println();
		System.out.println(time);
		BigInteger v = new BigInteger(1,result);
		String code1 = String.format("%064x", v);
		System.out.println(new BigInteger(1,result).toString(16));
		System.out.println(code1);
		System.out.println(v);
	}
}
//d7333b9b4889678ba931944f3c05bd22967b81494458762ee59608b7fb3d6cd0
//vdsvs9
//4a8708c3a481ced13845a30de522486895de0592222c29326d9139ec2b9df25
//02d20bbd7e394ad5999a4cebabac9619732c343a4cac99470c03e23ba2bdc2bc