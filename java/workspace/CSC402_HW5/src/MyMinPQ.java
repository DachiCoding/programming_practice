//CSC402 HW5
//@author DACHI XU

import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyMinPQ<E extends Comparable<E>> implements Iterable<E>
{
	private ArrayList<E> items;
	
	public MyMinPQ(){
	   this.items = new ArrayList<E>();
	}
	
	public E delMin(){
		// removes and returns the minimum item
		if (this.items.isEmpty()){
			throw new NoSuchElementException();
		}
		else {
			int size = this.items.size();
			E minItem = this.items.get(size-1);
			this.items.remove(size-1);
			return minItem;
		}
	}
 
	public E min(){
		// return the minimum item
		int size = this.items.size();
		return this.items.get(size-1);
	}
 
	public void insert(E item){
		this.items.add(item);
		int itemIdx = this.items.size()-1;
		
		//Only sort if have more than one element
		if (itemIdx > 1){
			while (itemIdx > 0 && this.items.get(itemIdx).compareTo(this.items.get(itemIdx-1)) > 0) {
				E tmp = this.items.get(itemIdx-1);
				this.items.set(itemIdx-1,item);
				this.items.set(itemIdx,tmp);
				itemIdx--;
			}
		}
	}
 
	public boolean isEmpty(){
		// is the priority queue empty?
		return this.items.size() > 0;
	}
 
	public int size(){
		// return the number of items in the priority queue
		return this.items.size();
	}
 
	public Iterator<E> iterator(){
		return this.items.iterator();
	}
}
