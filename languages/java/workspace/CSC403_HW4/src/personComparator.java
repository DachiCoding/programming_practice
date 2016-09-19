import java.util.Comparator;

public class personComparator implements Comparator{
	  String firstName;
	  String lastName;
	  int age;
	  
	  public personComparator(String fname, String lname, int ageNum){
		  this.firstName = fname;
		  this.lastName = lname;
		  this.age = ageNum;
	  }

	  public int compare(Object o1, Object o2) {
		    personComparator p1 = (personComparator) o1;
		    personComparator p2 = (personComparator) o2;
			if (p1.age < p2.age){
				return -1;
			}
			else if (p1.age > p2.age){
				return 1;
			}
			else {
				return 0;
			}
	  }
	
	  public String toString(){
		return this.firstName + "," + this.lastName + " " + Integer.toString(this.age);
	  }
}
