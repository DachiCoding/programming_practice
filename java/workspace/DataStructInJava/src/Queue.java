
public interface Queue<E> {
	/** Return the number of elements in the queue */
	int size();
	
	/** Test whether the queue is empty */
	boolean isEmpty();
	
	void enqueue(E e);
	
	E first();
	
	E dequeue();
}
