import java.lang.Object;

public class HW1 {
 public static void main(String[] args){
	 //Ex1.1.1
	 System.out.println((0+15)/2);
	 System.out.println(2.0e-6 * 100000000.1);
	 System.out.println(true && false || true && true);
	 
	 //Ex1.1.2
	 System.out.println((1 + 2.236)/2);
	 System.out.println(1 + 2 + 3 + 4.0);
	 System.out.println(4.1 >= 4);
	 System.out.println(1 + 2 + "3");
	
	 //Ex1.1.3
	 ifEqual(1,1,2);
	 ifEqual(1,1,1);
	 
	 //Ex1.1.4
	 /*
	 a. if (a > b) then c = 0; then is no use
	 b. if a > b { c = 0; } ok
	 c. if (a > b) c = 0;ok
	 d. if (a > b) c = 0 else b = 0; missing semicolon
	 */
	 
	 //Ex1.1.6
	 int f=0;
	 int g=1;
	 for(int i=0;i<15;i++)
	 {
		 System.out.println(f);
		 f=f+g;
		 g=f-g;
	 }
 }
 
 //
 public static void ifEqual(int arg1,int arg2,int arg3){
	 if(arg1==arg2 && arg2 == arg3)
		 System.out.println("equal");
	 else
		 System.out.println("not equal");
 }
}
