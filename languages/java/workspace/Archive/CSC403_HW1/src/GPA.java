import java.util.Scanner;

//CSC403 Assignment1 
//By Dachi Xu

public class GPA {
	public static void main(String args[]){
		ST<String,Double> gpaTable = new ST<String,Double>();
		gpaTable.put("A", 3.5);
		gpaTable.put("B", 2.5);
		gpaTable.put("C", 1.5);
		gpaTable.put("D", 1.0);
		gpaTable.put("F", 0.0);
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter your grade(A/B/C/D/F): ");
		double total = 0, count = 0, average = 0;
		String input = reader.nextLine();
		String[] inputArray = input.split(" ");
		for(int i = 0; i < inputArray.length;i++ )
		{
		 count++;
		 total += gpaTable.get(String.valueOf(inputArray[i]));
		}
		average = total / count;
		
		System.out.println("Your aveage GPA is " + average);
		
	}
}
