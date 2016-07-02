
public class SelectionSort {
	public static void sort(Comparable[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			Comparable smallest;
			for(int j = i; j < a.length; j++){
			  if (less(a[j+1],a[j]))
			   smallest = a[j+1];
			   exch(a,1,j+1);
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w)
	{ return v.compareTo(w) < 0;}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
}
