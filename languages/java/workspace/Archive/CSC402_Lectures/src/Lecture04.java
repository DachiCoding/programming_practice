
public class Lecture04 {
	private static int x;
	private int y;
	
	//method incrY
	public void incrY(int y)
	{
		this.y = this.y + y;
	}

	//method f
	public void f(int z)
	{
		int w;
		int x;
		x = 6; //local 
		Lecture04.x = 5;
		this.y = 10;
	}

	//method g
	public static void g()
	{
		x = 5;
	}

	//main method
	public static void main(String args[])
	{
		/*
		System.out.println(x);
		g();
		System.out.println(x);
		*/
		
		MyLinkedStack s = new MyLinkedStack();
		for(int i =0; i <= 10; i++){
			s.push(i);
		}
		while(!s.isEmpty()){
			int x = s.pop();
			System.out.println(x);
		}
	}
}
