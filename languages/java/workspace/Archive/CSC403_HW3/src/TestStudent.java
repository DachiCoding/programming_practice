//CSC403 Data Structure 2 Assignment 3
//Dachi Xu

public class TestStudent {
	public static void main(String[] args) {
		Student alice = new Student("Alice", 3);
		Student bob   = new Student("Bob",   3);
		Student ali   = new Student("Alice", 3);
		String fred = "Fred";

		StdOut.println("alice == ali:        " + (alice == ali));
		StdOut.println("alice.equals(ali):   " + (alice.equals(ali)));
		StdOut.println("alice.equals(bob):   " + (alice.equals(bob)));
		StdOut.println("alice.equals(fred):  " + (alice.equals(fred)));
	} 
}
