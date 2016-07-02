import java.util.Scanner;

public class bmTest {
  public static void main(String args[]){
	  System.out.println("BoyerMoore Client Test...");
	  Scanner inputScan = new Scanner(System.in);
	  System.out.print("Please enter some text: ");
	  String text = inputScan.nextLine();
	  System.out.print("Please enter the text to search(pattern): ");
	  String patt = inputScan.nextLine();
	  BoyerMoore brInstance = new BoyerMoore(patt);
	  int index = brInstance.search(text);
	  if (index >= 0 && index < text.length()){
		  System.out.print(patt + " index: " + (index + 1));
	  }
	  else {
		  System.out.println("No matching text could be found.");
	  }  
  }
}
