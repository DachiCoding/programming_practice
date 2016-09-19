
public class PromoDemo {
	public static void main(String args[]){
		byte b;
		int i;
		
		b = 10;
		i = b * b;
		
		b = 10;
		b = (byte) (b * b);
		System.out.println("i and b: " + i + " " + b);
	}
}
