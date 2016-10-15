public class personComparable implements Comparable{
	  String firstName;
	  String lastName;
	  int age;
	  
	  public personComparable(String lname, String fname, int ageNum){
		  this.lastName = lname;
		  this.firstName = fname;
		  this.age = ageNum;
	  }

	public int compareTo(Object o) {
		personComparable comparePerson = (personComparable) o;
		return this.lastName.compareTo(comparePerson.lastName);
	}
	
	public String toString(){
		return this.lastName + "," + this.firstName + " " + Integer.toString(this.age);
	}
}
