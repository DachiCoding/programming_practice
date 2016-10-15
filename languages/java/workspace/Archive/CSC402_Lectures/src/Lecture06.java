
public class Lecture06 {
	public class ArrayStack<E> implements Iterable<E> {
		private E[] store;
		private int sz;
		
		public ArrayStack()
		{
			store = new E[10]; //store = (E[]) new Object[10];
			sz = 0;
		}
		
		public void resize(int newsize)
		{
			E[] tmp = (E[]) new object[newsize];
			for(int i = 0; i < store.length; i++){
				tmp[i] = store[i];
			}
			store = tmp;
		}
		
		public void push(E x)
		{
			
		}
		
		public E pop()
		{
			if ( sz == store.length)
			{
				resize(2*sz);
			}
		}
		
		public E peek()
		{
			
		}
		
		public int size()
		{
			
		}
		
		public boolean isEmpty()
		{
			
		}
		
		public Iterator<E> iterator(){
			
		}
	}
	
	public class MyList {
		private Node first; 
		
		public MyList()
		{
			first = null;
		}
		
		public void addFirst(int x)
		{
			Node tmp = new Node(x);
			if (first == null){
				first = tmp;
			} else {
				tmp.next = first;
				first = tmp;
			}
		}
		
		public int sizeOdd()
		{
			Node p;
			int cnt = 0;
			p = first;
			while(p != null){
				if (p.data % 2 != 0)
					cnt++;
				p = p.next;
			}
			return cnt;
		}
		
		private class Node
		{
			private int data;
			private Node next;
			
			private Node(int x)
			{
				this.data = x;
			}
		}
	}
}
