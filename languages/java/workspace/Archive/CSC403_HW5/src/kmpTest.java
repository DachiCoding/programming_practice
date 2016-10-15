import java.util.Scanner;

public class kmpTest {
	  public static void main(String args[]){
		  System.out.println("KMP Client Test...");
		  Scanner inputScan = new Scanner(System.in);
		  System.out.print("Please enter some text: ");
		  String text = inputScan.nextLine();
		  System.out.print("Please enter the text to search(pattern): ");
		  String patt = inputScan.nextLine();
		  
		  KMP kmpInstance = new KMP(patt);
		  int index = kmpInstance.search(text);
		  if (index >= 0 && index < text.length()){
			  System.out.print("Pattern found: " + patt + " index: " + (index + 1));
		  }
		  else {
			  System.out.println("No matching text could be found.");
		  }  
	  }
}
