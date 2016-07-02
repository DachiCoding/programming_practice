import java.util.Comparator;
import java.util.Scanner;

//CSC403 HW4 
//Dachi Xu

public class strSortComparator {
	personComparator people[];
	personComparator current;
	  	  	  
	  public strSortComparator(personComparator input[]){
		  this.people = new personComparator[input.length];
		  System.arraycopy( input, 0, people, 0, input.length );
	  }
	  
	  private static void exch(Comparator[] a, int i, int j)
	  {  Comparator t = a[i]; a[i] = a[j]; a[j] = t;  }
	  
	  
	  /*
	  public void sortByLastName(){
		  int N = this.people.length;               // array length
	        for (int i = 0; i < N; i++)
	        {  // Exchange a[i] with smallest entry in a[i+1...N).
	           int min = i;                 // index of minimal entr.
	           for (int j = i+1; j < N; j++){
	              if (this.people[j].compareTo(this.people[min]) < 0) min = j;
	           }
	           exch(this.people, i, min);
	      }
	  }
	  */
	  
	  public void sortByAge(){
		  int N = this.people.length;               // array length
	        for (int i = 0; i < N; i++)
	        {  // Exchange a[i] with smallest entry in a[i+1...N).
	           int min = i;                 // index of minimal entr.
	           for (int j = i+1; j < N; j++){
	              if (this.people[j].compare(this.people[j],this.people[min]) < 0 ) min = j;
	           }
	           exch(this.people, i, min);
	      }
	  }
	  
	  public static void main(String args[]){

		  int arrayLimit = 15;
		  
		  //Reading names;
		  personComparator[] people = new personComparator[arrayLimit];
		  String[] nameArray;
		  int count = 0;
		  
		  Scanner nameScan = new Scanner(System.in);
		  
		  while (count < arrayLimit){
		   System.out.print("Please enter the person's last name, first name and age, split by space: ");
		   nameArray = nameScan.nextLine().split(" ");
		   people[count] = new personComparator(nameArray[0],nameArray[1],Integer.parseInt(nameArray[2]));
		   count++;
		  }		 

		  //Output original name sequence
		  System.out.println();
		  System.out.println("List of names before sort on age : ");
		  for(int i = 0; i < people.length;i++){
	        System.out.println(people[i].toString());
		  }
		  
		  //Output sorted name sequence order by age
		  strSortComparator pplSortByAge = new strSortComparator(people);
		  pplSortByAge.sortByAge();
		  System.out.println();
		  System.out.println("List of names after sort on age : ");
		  for(int i = 0; i < pplSortByAge.people.length;i++){
		        System.out.println(pplSortByAge.people[i].toString());
		  }
		  
	  }


}
