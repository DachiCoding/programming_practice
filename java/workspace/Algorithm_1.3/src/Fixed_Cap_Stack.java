import java.util.Scanner;

public class Fixed_Cap_Stack {
	public static void main(String args[]){
		FixedCapacityStackOfStrings s;
		s = new FixedCapacityStackOfStrings(100);
		System.out.print("Tyep some words:");
		Scanner in = new Scanner(System.in);
		while (!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}
