import java.util.ArrayList;


public class Lecture03 {
 public static void main(String[] args){
	 //Copy class type
	 StringBuffer s1 = new StringBuffer();
	 StringBuffer s2 = new StringBuffer();
	 s1.append("abc");
	 s2=s1;
	 System.out.println(s1);
	 System.out.println(s2);
	 s1.append("d");
	 System.out.println(s1);
	 System.out.println(s2);
	 
	 //Compare Class
	 StringBuffer s3 = new StringBuffer("abcd");
	 if (s1 == s3){
		 System.out.println("s1 == s3 works.");
	 } else {
		 System.out.println("Oops.");
	 }
	 
	 if (s1.equals(s3)){
		 System.out.println("s1.equal(s3) works.");
	 } else {
		 System.out.println("What?!");
	 }
	 
	 if (s1.toString().equals(s3.toString())) {
		 System.out.println("s1.toString().equals(s3.toString()) works.");
	 } else {
		 System.out.println("Really?!");
	 }
	 
	 ArrayList<Integer> lst = new ArrayList<Integer>();
	 for(int i = 0; i < 5; i++) {
	    	      lst.add(i);
	 }
	    	    
	 int sum = 0;
	    	    
	 for(int i = 0; i < lst.size(); i++) {
	   	      sum = sum + lst.get(i);  // what type is lst.get(i)
	 }
	 System.out.printf("sum = %d\n", sum);
	 
	 System.out.println(System.currentTimeMillis());
 }
}
