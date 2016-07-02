/*
 * CSC402 Data Structure I HW2
 * Dachi Xu, ID#1451968, dachi.xu@gmail.com
 */

import static java.lang.System.out;

import java.lang.Object;
import java.util.Scanner;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class PrintSum {
 public static void PrintSumApp(){
	/*
	 * This function will read the input from a file and print the numbers of integers read, the 
	 * count and sum of the even/odd/all integers.
	 * @param file of integers
	 * @return count/sum of the odd/even/total integers in the file
	 * @exception
	 */
	String msg = "This program reads an input file of integers and prints the\n" +
				 "sum of the even integers, the sum of the odd integers, the\n" +
				 "sum of all integers, and the number of integers read.\n";
	int currentNum = 0;
	int oddSum = 0;
	int evenSum = 0;
	int totalSum=0;
	int oddCount=0;
	int evenCount=0;
	int totalCount=0;
	out.println(msg);
	
	//1.Prompt for the name of the input file
	out.print("Enter file name:");
	Scanner stdin = new Scanner(System.in);
	String fname = stdin.nextLine();
	Scanner fileScan = new Scanner(fname);
	try { 
		fileScan = new Scanner(new FileReader(fname));
	} catch(FileNotFoundException ex) {
		ex.printStackTrace();
	}

	/*
	 * 2.Read the integers in the file.You may assume that the file contains integers.
	 * 3.Count the even integers, the odd integers, and all integers.
	 * 4.Compute the sum of the even integers, the sum of the odd integers, and the sum of all 
	 * integers read.
	*/
	while(fileScan.hasNextInt()){
		currentNum = fileScan.nextInt();
		if (currentNum % 2 == 0){
			evenCount++;
			evenSum += currentNum;
		} else {
			oddCount++;
			oddSum +=currentNum;
		}
		totalCount++;
		totalSum += currentNum;
	}
	
	//5 The program should print the results in the format shown in the example below.
	out.printf("There were %d integers read.\n",totalCount);
	out.printf("Sum of the %d even integers: %d\n", evenCount,evenSum);
	out.printf("Sum of the %d odd integers: %d\n", oddCount,oddSum);
	out.printf("Sum of all integers: %d\n",totalSum);
 }
}
