import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.naming.OperationNotSupportedException;

/**
* CSC402 HW4, Deque an linear data type allowing insertions and deletions at
￼￼￼￼￼* both ends.
*
*@author (dachi xu) 
**/

public class Deque<E> implements Iterable<E> {
	//Data members for Deque
	private Node head;
	private Node tail;
	private int size;
	
	//Node Class
	private class Node {
		private E data; 
		private Node prev; 
		private Node next; 
		private Node(E x) {
		data = x;
		prev = next = null; 
		}
    }

	//Method for Deque
	public Deque() {
		this.head = new Node(null);
		this.tail = new Node(null);
		head.next = tail;
		tail.prev = head;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void addFirst(E x)
	{
		if(x == null){
			throw new NullPointerException();
		}
		Node newFirst = new Node(x);
		newFirst.next = head.next;
		newFirst.prev = head;
		head.next.prev = newFirst;
		head.next = newFirst;
		size++;
	}
	
	public void addLast(E x){
		if(x == null){
			throw new NullPointerException();
		}
		Node newLast = new Node(x);
		tail.prev.next = newLast;
		tail.prev = newLast;
		newLast.prev = tail.prev;
		newLast.next = tail;
		size++;
	}
	
	public E removeFirst(){
		if(size == 0){
			throw new NoSuchElementException();
		}
		E value = head.next.data;
		head.next = head.next.next;
		head.next.prev = head;
		size--;
		return value;
	}
	
	public E removeLast(){
		if(size == 0){
			throw new NoSuchElementException();
		}
		E value = tail.prev.data;
		tail.prev = tail.prev.prev;
		tail.prev.next = tail;
		size--;
		return value;
	}
	
	public class dequeIterator<E> implements Iterator<E> {
		
		private Deque currentDeque;
		private Node currentNode;
		
		public dequeIterator(Deque theDeque){
			currentDeque = theDeque;
			currentNode  = theDeque.head;
		}
		
		@Override
		public boolean hasNext(){
			return currentNode.next != currentDeque.tail;
		}
		
		@Override
		public E next(){
			if(!this.hasNext()){
				throw new NoSuchElementException();
			}
			else
				return (E) currentNode.next.data;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
			/*  
			 * 	currentNode.prev.next = currentNode.next;
			 *	currentNode.next.prev = currentNode.prev;
			 *  currentDeque.size--;
			 */
		}
	}
	
	public Iterator<E> iterator(){
		return new dequeIterator(this);
	}
}
