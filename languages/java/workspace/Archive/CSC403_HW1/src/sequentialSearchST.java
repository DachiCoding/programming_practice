import java.util.Iterator;

public class sequentialSearchST<Key,Value>
{
 	private Node first;

 	private class Node
 	{
 		Key key;
 		Value val;
 		Node next;
 		public Node(Key key,Value val,Node next)
 		{
 			this.key = key;
 			this.val = val;
 			this.next = next;
 		}
 	}
 	
    public Value get(Key key)
 	{
 			for (Node x = first; x != null; x = x.next){
 				if (key.equals(x.key))
 					return x.val;
 			}
 			return null;
 	}
    
    public void put(Key key, Value val)
    {
    	for (Node x = first; x != null; x = x.next)
    	{
    		if (key.equals(x.key))
    		{  x.val = val; return; }
    	}
    	first = new Node(key,val,first);
    }
    
    public int size()
    {
    	int count = 0;
    	for (Node x = first;x !=null; x = x.next){
    		count++;
    	}
    	return count;
    }
    
    public void delete(Key key)
    { 			
    	Node x = first;
    	if (x.key.equals(key)){
    		first = x.next;
    		return;
    	}
    	
    	while( !x.next.key.equals(key) ){
    		x = x.next;
    	}
    	x.next = x.next.next;
    }
    
    public Iterable<Key> keys()
    {
    	Node x = first;
    	Queue<Key> q = new Queue<Key>();
    	int count = 0;
    	while( x != null){
    		q.enqueue(x.key);
    		x = x.next;
    		count++;
    	}
    	return q;
    }
    
    public static void main(String args[]){
    	sequentialSearchST<String,Double> gpaTable = new sequentialSearchST<String,Double>();
    	gpaTable.put("A", 3.5);
		gpaTable.put("B", 2.5);
		gpaTable.put("C", 1.5);
		gpaTable.put("D", 1.0);
		gpaTable.put("F", 0.0);
		System.out.println("Keys are: " +gpaTable.keys());
		System.out.println("The size of gpaTable is : " + gpaTable.size());
		gpaTable.delete("A");
		System.out.println("Keys are: " +gpaTable.keys());
		System.out.println("The size of gpaTable is : " + gpaTable.size());
    }
    
}
