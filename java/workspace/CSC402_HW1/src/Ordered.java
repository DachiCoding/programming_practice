//CSC402 Data Structure I HW1 Ordered.java
//Dachi Xu , ID#1451968, dachi.xu@gmail.com

import java.util.Scanner;

public class Ordered {
 public static void OrderdFunc(){
		/**
		 * OrderedFunc will take 3 integers and judge if they are in monotonously increasing or decreasing. 
		 * @param NA 
		 * @return NA
		 * @exception NA
		 */
	   System.out.print("Enter three integers: ");
	   Scanner stdin = new Scanner(System.in);
	   String intString[] = new String[3];
	   int intArray[] = new int[3];
	   String intScan = stdin.nextLine();
	   intString = intScan.split(" ");
	   for(int i=0;i<intString.length;i++){
		   intArray[i]=Integer.parseInt(intString[i]);
	   }
	   if(Integer.signum(intArray[0]-intArray[1])==Integer.signum(intArray[1]-intArray[2]))
		   System.out.println("True.");
	   else
		   System.out.println("False.");
 }
}
