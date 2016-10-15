import java.util.Scanner;


public class Stopwatch {
	private final long start;
	
	public Stopwatch()
	{  
		start = System.currentTimeMillis();  
	}
	
	public double elapsedTime()
	{
	      long now = System.currentTimeMillis();
	      return (now - start) / 1000.0;
	}
	
	public static void main(String args[]){
		   Scanner intScan = new Scanner(System.in);	
		   int N = intScan.nextInt();
		   int[] a = new int[N];
		   for (int i = 0; i < N; i++)
		      a[i] = StdRandom.uniform(-1000000, 1000000);
		   Stopwatch timer = new Stopwatch();
		   int cnt = ThreeSum.count(a);
		   double time = timer.elapsedTime();
		   StdOut.println(cnt + " triples " + time);
	}
}
