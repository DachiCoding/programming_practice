/*
 * CSC402 Data Structure I HW2
 * Dachi Xu, ID#1451968, dachi.xu@gmail.com
 */

import static java.lang.System.out;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class TwoSumZero {
   public static void TwoSumZeroApp(){
		/*
		 * This function will read the input from a file and print the numbers of integers read, the 
		 * count and sum of the even/odd/all integers.
		 * @param file of integers
		 * @return find out the integer pair which has a sum of zero
		 * @exception
		 */
	   
	   //output heads up
	   String msg = "This program reads a file of integers - positive, negative, 0-\n" +
			   		"and determin all pairs of the entries with sum 0.\n";
	   out.println(msg);
	   
	   //read the file name
	   out.print("Enter file name:");
	   Scanner stdin = new Scanner(System.in);
	   String fname = stdin.nextLine();
	   Scanner fscan = new Scanner(fname);
		try { 
			fscan = new Scanner(new FileReader(fname));
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		//read the integers from file
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		int currentNum;
		while (fscan.hasNextInt()){
			currentNum = fscan.nextInt();
			intArray.add(currentNum);
		}
		
		//loop through the integers to find out zero sum pairs.
		int num1=0,num2=0;
		int arrayLength = intArray.size();
		for(int i=0;i<arrayLength-1;i++){
			for(int j=i+1;j<arrayLength;j++){
				num1=intArray.get(i);
				num2=intArray.get(j);
				if(num1 + num2 == 0)
					out.printf("nums[%d] + nums[%d] = %d + %d = 0\n",i,j,num1,num2);
			}
		}
   }
}
