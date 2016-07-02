//CSC403 Assignment 2-1 
//Dachi Xu

public class BST<Key extends Comparable<Key>,Value>
{
	private Node root;
	private class Node
	{
	   private Key key;
	   private Value val;
	   private Node left, right;
	   private int N;
	// root of BST
	// key
	// associated value
	// links to subtrees
	// # nodes in subtree rooted here
	   public Node(Key key, Value val, int N)
	   {  this.key = key; this.val = val; this.N = N; }
	}
	
	public int size()
	{  return size(root);  }
	
	private int size(Node x)
	{
	   if (x == null) return 0;
	   else           return x.N;
	}
	
	public Value get(Key key)
	{
		return get(root, key);
	}
	
	private Value get(Node x, Key key)
	{  // Return value associated with key in the subtree rooted at x;
	     // return null if key not present in subtree rooted at x.
	     if (x == null) return null;
	     int cmp = key.compareTo(x.key);
	     if      (cmp < 0) return get(x.left, key);
	     else if (cmp > 0) return get(x.right, key);
	     else return x.val;
	}
	
	public void put(Key key, Value val)
	{
		root = put(root,key,val);
	}
	
	private Node put(Node x, Key key, Value val)
	{
		if (x == null) return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.left = put(x.left,key,val);
		else if (cmp > 0) x.right = put(x.right,key,val);
		else x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Key min()
	{
		return min(root).key;
	}
	
	private Node min(Node x)
	{
		if (x.left == null) return x;
		return min(x.left);
	}
	
	public Key max()
	{
		return max(root).key;
	}
	
	private Node max(Node x)
	{
		if (x.right == null) return x;
		return max(x.right);
	}	
	public Key floor(Key key)
	{
		Node x = floor(root,key);
		if (x == null) return null;
		return x.key;
	}
	
	private Node floor(Node x, Key key)
	{
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		if (cmp < 0)  return floor(x.left,key);
		Node t = floor(x.right,key);
		if (t != null) return t;
		else return x;
	}

	public Key ceiling(Key key)
	{
		Node x = ceilling(root,key);
		if (x == null) return null;
		return x.key;
	}
	
	private Node ceilling(Node x, Key key)
	{
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		if (cmp < 0)  return ceilling(x.right,key);
		Node t = ceilling(x.left,key);
		if (t != null) return t;
		else return x;
	}	
	
	public Key select(int k)
    {
     return select(root, k).key;
    }
	
	private Node select(Node x, int k)
	{   // Return Node containing key of rank k.
	      if (x == null) return null;
	      int t = size(x.left);
	      if      (t > k) return select(x.left,  k);
	      else if (t < k) return select(x.right, k-t-1);
	      else            return x;
	}
	
	public int rank(Key key)
    {  return rank(key, root);  }
	  
	private int rank(Key key, Node x)
	{  // Return number of keys less than x.key in the subtree rooted at x.
	     if (x == null) return 0;
	     int cmp = key.compareTo(x.key);
	     if      (cmp < 0) return rank(key, x.left);
	     else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
	     else              return size(x.left);
	}
	  
	public void deleteMin()
	{
	     root = deleteMin(root);
	}
	
	private Node deleteMin(Node x)
	{
	     if (x.left == null) return x.right;
	     x.left = deleteMin(x.left);
	     x.N = size(x.left) + size(x.right) + 1;
	     return x;
	}
	
	public void deleteMax()
    {
	    root = deleteMax(root);
	}
	  
	private Node deleteMax(Node x)
	{
	     if (x.right == null) return x.left;
	     x.right = deleteMax(x.right);
	     x.N = size(x.right) + size(x.left) + 1;
	     return x;
	}	  
	
	public void delete(Key key)
	{  root = delete(root, key);  }
	
	private Node delete(Node x, Key key)
	{
	     if (x == null) return null;
	     int cmp = key.compareTo(x.key);
	     if      (cmp < 0) x.left  = delete(x.left,  key);
	     else if (cmp > 0) x.right = delete(x.right, key);
	     else
	     {
	        if (x.right == null) return x.left;
	        if (x.left == null) return x.right;
	        Node t = x;
	        x = min(t.right);  // See page 407.
	        x.right = deleteMin(t.right);
	        x.left = t.left;
	     }
	     x.N = size(x.left) + size(x.right) + 1;
	     return x;
	}
	  
	public Iterable<Key> keys()
	{  return keys(min(), max());  }
	
	public Iterable<Key> keys(Key lo, Key hi)
	{
	      Queue<Key> queue = new Queue<Key>();
	      keys(root, queue, lo, hi);
	      return queue;
	}
	
	private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
	  {
	     if (x == null) return;
	     int cmplo = lo.compareTo(x.key);
	     int cmphi = hi.compareTo(x.key);
	     if (cmplo < 0) keys(x.left, queue, lo, hi);
	     if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
	     if (cmphi > 0) keys(x.right, queue, lo, hi);
	}
	
	public int height()
	{  return height(root);  }
	
	private int height(Node x)
	{
	   if (x == null) { return 0;}
	   if (x.N == 1) {
		   return 1;
	   }
	   else {
		   return height(x.left) > height(x.right) ? (height(x.left)+1):(height(x.right)+1);
	   }
	}
	
	/* Test Client */
	public static void main(String args[])
	{
		//Initialize BST and put items
		System.out.println("Please enter BST items:");
		BST<Integer,String> imdbTop250 = new BST<Integer,String>();
		imdbTop250.put(5,"The Pulp Fiction");
		imdbTop250.put(14,"Forest Gump");
		imdbTop250.put(1, "The Shawshank Redemption");
		imdbTop250.put(8,"12 Angry Men");
		imdbTop250.put(2,"The Godfather ");
		imdbTop250.put(10,"The Fight Club");
		imdbTop250.put(4,"The Dark Knight ");
		imdbTop250.put(9,"The Lord of the Rings: The Return of the King");
		imdbTop250.put(3,"The Godfather 2");
		imdbTop250.put(13,"Inception");
		imdbTop250.put(15,"One Flew Over the Cuckoo's Nest");
		imdbTop250.put(17,"Goodfellas");
		imdbTop250.put(18,"Matrix");
		imdbTop250.put(28,"Life is beautiful");
		imdbTop250.put(50,"Alien");
		
		//Test height() function
		System.out.println("The binary tree has a size of : " + imdbTop250.size());
		System.out.println("The binary tree has a height of : " + imdbTop250.height());
	}
}
