import java.util.Scanner;

public class GPA {
  public static void main(String args[]){
	  ST<String,Double> gpaTable = new ST<String,Double>();
	  gpaTable.put("A+", 4.33);
	  gpaTable.put("A", 4.00);
	  gpaTable.put("A-", 3.67);
	  gpaTable.put("B+", 3.33);
	  gpaTable.put("B", 3.00);
	  gpaTable.put("B-", 2.67);
	  gpaTable.put("C+", 2.33);
	  gpaTable.put("C", 2.00);
	  gpaTable.put("C-", 1.67);
	  gpaTable.put("D", 1.00);
	  gpaTable.put("F", 0.00);
	  
	  Scanner reader = new Scanner(System.in);
	  System.out.println("Please enter your grade: ");
	  String grades[] = reader.nextLine().split(" ");
	  Double totalGrade = 0.0;
	  for(int i = 0; i < grades.length;i++){
		  totalGrade += gpaTable.get(grades[i]);
	  }
	  System.out.format("The average gpa is %.2f",totalGrade/grades.length);
	  
  }
}
