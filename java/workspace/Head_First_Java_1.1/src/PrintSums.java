import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintSums {
 public static void directions()
 {
	 String msg =
			 "This program prompts for an input file name\n" +
	         "containing positive and negative integers.\n" +
			 "It reads integers and prints the sum of the positives.\n" +
	         "and separately. the sum of the negatives\n";
	 System.out.println(msg);
 }
 
 public static Scanner openInput(String fname)
 {
	Scanner inFile = null;
	
	try {
	 inFile = new Scanner(new File(fname));
	} catch (FileNotFoundException e){
	 System.out.println("Can't open " + fname);
	 System.exit(0);
	}
	
	return inFile;
 }
 
 public static void main(String[] args)
 {
    System.out.print("Enter file name: ");
    Scanner stdin = new Scanner(System.in);
    String fnm;
    fnm = stdin.next();
    Scanner in = openInput(fnm);
    int sumpos = 0;
    int sumneg = 0;
    
    while(in.hasNextInt()){
    	int x = in.nextInt();
    	if (x >= 0){
    		sumpos = sumpos + x;
    	sumpos += x;
      } else {
    	sumneg += x;
      }
    }
    System.out.println("sumpos = %d\n",sumpos);
    System.out.println("sumneg = %d\n",sumpos);
 }
}
