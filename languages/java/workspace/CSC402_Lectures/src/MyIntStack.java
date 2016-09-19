import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyIntStack {
  private int[] store;
  private int capacity;
  private int size;
  
  public MyIntStack()
  {
	  capacity = 10;
	  size = 0;
	  store = new int[capacity];
  }
  public int pop()
  {
	  if (isEmpty()) {
		  throw new NoSuchElementException();
	  }
	  //assert(!isEmpty());
	  int x = store[size -1];
	  size--;
	  return x;
  }
  
  public int peek()
  {
	  if (isEmpty()) {
		  throw new NoSuchElementException();
	  }
	  return store[size-1];
  }
  
  public void push(int x)
  {
	  if (size == capacity) {
		  ensureCapacity(2 * capacity); //roll the stack,double the capacity
	  }
	  store[size] = x;
	  size++;
  }
  
  public boolean isEmpty()
  {
	  return size == 0;
  }
  
  private void ensureCapacity(int newcapacity)
  {
	  int[] temp = new int[newcapacity];
	  for(int i =0; i < size; i++) {
		  temp[i] = store[i];
	  }
	  capacity = newcapacity;
	  store = temp;
  }
  
  private class myStackIterator implements Iterator<Integer>
  {
	  private int pos;
	  
	  public void MyStackIterator()
	  {
		  pos = size - 1;
	  }
	  
	  @Override
	  public boolean hasNext() {
		  return pos >= 0;
	  }
	  
	  @Override
	  public Integer next() {
		  Integer x = store[pos];
		  pos--;
		  return x;
	  }
	  
	  @Override
	  public void remove() {
		  throw new UnsupportedOperationException();
	  }
  }
  
  public static void main(String[] args)
  {
	  MyIntStack s = new MyIntStack();
	  for(int i=0; i<=50; i++){
		  s.push(i);
	  }
	  
	  while(!s.isEmpty()){
		  int x = s.pop();
		  System.out.println(x);
	  }
	  
	  Iterator<Integer> it = s.iterator();
  }
}
