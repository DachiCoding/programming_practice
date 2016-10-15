import java.util.Scanner;

public class PrintMax {
 private static void directions()
 {
	 String msg =
			 "This program prompts for two input integers\n" + 
			 "and prints the larger of the two.\n";
	 System.out.println(msg);
 }
 
 public static void main(String[] args){
	 directions();
	 Scanner stdin = new Scanner(System.in);
	 System.out.print("Enter two integers: ");
	 int x;
	 int y;
	 x = stdin.nextInt();
	 y = stdin.nextInt();
	 if ( x > y){
		 System.out.println("max = "+ x);
	 } else if (x < y){
		 System.out.println("max = "+ y);
	 }
	 else {
		 System.out.println("The two numbers are equal.");
	 }
  }
}
