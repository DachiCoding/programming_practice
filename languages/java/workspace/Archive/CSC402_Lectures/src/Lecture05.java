
public class Lecture05 {
	public static void main(String args[])
	{
		String s1 = "bad";
		String s2 = s1;
		s1 = "fad";
		System.out.printf("%s %s\n",s1,s2);
		
		StringBuffer sb1 = new StringBuffer("bad");
		StringBuffer sb2 = sb1;
		sb1.replace(0, 3, "fad");
		System.out.printf("%s %s\n",sb1,sb2);
	}
}
