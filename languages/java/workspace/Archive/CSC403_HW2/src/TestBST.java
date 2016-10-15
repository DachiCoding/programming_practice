//CSC403 Assignment 2-2
//Dachi Xu

public class TestBST {
	public static void main(String args[]){
		System.out.println("Please enter BST items:");
		BST<Integer,String> imdbTop250 = new BST<Integer,String>();
		imdbTop250.put(1, "The Shawshank Redemption");
		imdbTop250.put(2,"The Godfather ");
		imdbTop250.put(4,"The Dark Knight ");
		imdbTop250.put(3,"The Godfather 2");
		imdbTop250.put(5,"The Pulp Fiction");
		imdbTop250.put(8,"12 Angry Men");
		imdbTop250.put(10,"The Fight Club");
		imdbTop250.put(9,"The Lord of the Rings: The Return of the King");
		imdbTop250.put(13,"Inception");
		imdbTop250.put(14,"Forest Gump");
		imdbTop250.put(15,"One Flew Over the Cuckoo's Nest");
		imdbTop250.put(17,"Goodfellas");
		imdbTop250.put(18,"Matrix");
		imdbTop250.put(28,"Life is beautiful");
		imdbTop250.put(50,"Alien");
		
		//min() test
		System.out.println("The min item is " + imdbTop250.min());
		//max() test
		System.out.println("The max item is " + imdbTop250.max());
		//floor() test
		System.out.println("The floor of 28 is " + imdbTop250.floor(50));
		//ceiling() test
		System.out.println("The ceiling of 2 is " + imdbTop250.ceiling(2));
		//select() test
		System.out.println("The first item's key is " + imdbTop250.select(0));
		//rank() test
		System.out.println("The rank of key = 50 element is " + imdbTop250.rank(50));
		//delete() test
		imdbTop250.delete(50);
		System.out.println("The max key after delete max key is " + imdbTop250.max());
		//deleteMin() test
		imdbTop250.deleteMin();
		System.out.println("The min key after delete min key " + imdbTop250.min());
		//deleteMax() test
		imdbTop250.deleteMax();
		System.out.println("The min key after delete max key " + imdbTop250.max());
		//keys() test
		System.out.println("The keys are :" + imdbTop250.keys());
	}
}
