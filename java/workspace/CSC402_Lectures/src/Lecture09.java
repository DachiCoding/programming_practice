
public class Lecture09 {
	public class selectionSort {
		int maxpos;
	   	
		public <E extends Comparable<E>> void sort(E[] a) { //注意这个用法
		   for(int k = a.length - 1; k > 0; k--){
			 maxpos = 0;
			 for(int j = 1; j <= k; j++) {
			   if (a[j].compareTo(a[maxpos]) > 0 ) {
				   maxpos =  j;
			   }
			 }
			 E tmp = a[maxpos];
			 a[maxpos] = a[k];
			 a[k] = tmp;
		   }
		}
	}
	
	public class insertionSort {
		
	}
	
	public static void main(String args[]){
		 
	}
}
