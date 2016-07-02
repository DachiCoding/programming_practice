

public class LinkedStack<E> implements Stack<E> {
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	public LinkedStack(){}
	public int size() {return list.size();}
	public boolean isEmpty() {return list.isEmpty();}
	
	public void push(E item) {
		list.addFirst(item);
	}
	
	public E pop() {
		return list.removeFirst();
	}
	
	public E top() {
		return list.first();
	}
	
}
