import java.awt.RenderingHints.Key;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ArrayST<Key extends Comparable<Key>,Value> {
	private node first;
	private int size;
	
	public class node {
		private Key key;
		private Value value;
		private node next;
		
		public node(Key key, Value val, node next){
			this.key = key;
			this.value = val;
			this.next = next;
		}
	}
	
	public void put(Key key, Value value){
		for(node x = first; x != null; x = x.next){
			if (x.key == key) { x.value = value; return;}
		}
		first = new node(key,value,first);
	}
	
	
	public Value get(Key key){
		for(node x = first; x !=null; x = x.next){
			if (x.key == key) { return x.value;}
		}
		return null;
	}
	
	public void delete(Key key){
		for(node x = first; x !=null; x = x.next){
			if (x.key == key) { x.value = null; }
		}
	}
	
	public boolean Contains(Key key){
		return this.get(key) != null;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	//public Iterable<Key> keys(){
		
	//}
	
	public static void main(String args[]){
		ArrayST<Integer,String> stTest = new ArrayST<Integer,String>();
		stTest.put(1, "Lucy");
		stTest.put(2, "GOG");
		System.out.println(stTest.get(2));
		System.out.println(stTest.get(1));
		stTest.delete(1);
		System.out.println(stTest.get(1));
		
	}
}
