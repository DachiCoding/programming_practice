//CSC402 Data Structure I HW1 HiFour.java
//Dachi Xu , ID#1451968, dachi.xu@gmail.com

import java.util.Scanner;

public class HiFour {

	public static void HiFourFunc(){
		/**
		 * HiFourFunc will take 4 names and print them out in reverse order.
		 * @param NA 
		 * @return NA
		 * @exception NA
		 */
		
		String names[] = new String[4];
		System.out.print("Enter four name:");
		Scanner sc = new Scanner(System.in);
		String nameline = sc.nextLine();
		names = nameline.split(" ");
		System.out.print("Hi");
		for(int i=names.length-1;i>=0;i--){
			if (i==0)
			 System.out.println(" and "+names[i]+".");
			else
			 System.out.print(" "+names[i]);
		}
	}
}
	
	 
