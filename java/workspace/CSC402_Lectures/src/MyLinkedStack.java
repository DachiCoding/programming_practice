import java.util.NoSuchElementException;

public class MyLinkedStack {
	private Node first;
	private int size;
	
	public MyLinkedStack()
	{
		first = null;
	}
	
	public void push(int x)
	{
		if (first == null){
			first = new Node(x);
		} else {
			Node tmp = new Node(x);
			tmp.next = first;
			first = tmp;
		}
	}
	
	public int pop()
	{
		/**
		 * @return and remove the top of the stack
		 * @throws NoSuchElementsExcetption if the stack is empty
		 */
		if (this.isEmpty())
		{
			throw new NoSuchElementException();
		}
		int x = first.item;
		first = first.next;
		return x;
	}
	
	public int peek()
	{
		if (this.isEmpty())
		{
			throw new NoSuchElementException();
		}
		return first.item;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public int size()
	{
		return size;
	}
	
}
