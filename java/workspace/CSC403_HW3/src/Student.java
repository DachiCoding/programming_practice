//CSC403 Data Structure 2 Assignment 3
//Dachi Xu

public class Student {
	private String name;
	private int section;
	public Student(String name, int section) {
		this.name    = name;
		this.section = section;
	}
	
	@Override public String toString(){
		return this.name;
	}
	
	public boolean equals(Object y) {
		/*
		 * ENTER YOUR CODE LOGIC HERE
		 */
		if (this == y) return true;
		if (y == null || y.getClass() != this.getClass()) return false;
		return this.toString() == y.toString();
	}
}
