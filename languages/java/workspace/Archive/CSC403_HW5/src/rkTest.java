import java.util.Scanner;

public class rkTest {
	  public static void main(String args[]){
		  System.out.println("RabinKarp Client Test...");
		  Scanner inputScan = new Scanner(System.in);
		  System.out.print("Please enter some text: ");
		  String text = inputScan.nextLine();
		  System.out.print("Please enter the text to search(pattern): ");
		  String patt = inputScan.nextLine();
		  
		  RabinKarp rkInstance = new RabinKarp(patt);
		  int index = rkInstance.search(text);
		  if (index >= 0 && index < text.length()){
			  System.out.print("Pattern found: " + patt + " index: " + (index + 1));
		  }
		  else {
			  System.out.println("No matching text could be found.");
		  }  
	  }
}
