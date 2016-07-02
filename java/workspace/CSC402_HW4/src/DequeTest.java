import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;


public class DequeTest {

	private Deque<Integer> q;

	@Before
	public void setUp() throws Exception {
		q = new Deque<Integer>();
	}

	/**
	 * test the Deque constructor initialization
	 */
	@Test
	public void test01() {
		assertEquals(true, q.isEmpty());
		assertEquals(0, q.size());
	}

	/**
	 * Test that addLast followed by removeLast will remove the element just added.
	 */
	@Test
	public void test02() {
		for(int i = 1; i <= 5; i++) {
			q.addLast(i);
			assertEquals(i, (int) q.removeLast());
		}
	}
	
	/**
	 * Test "stack" property at the end; that is adding and removing
	 * from the end is First In, Last Out (using addLast and removeLast)
	 */
	@Test
	public void test03() {
		for(int i = 1; i <= 5; i++) {
			q.addLast(i);
		}
		for(int i = 5; i >= 1; i--) {
			assertEquals(i, (int) q.removeLast());
		}
	}
	/**
	 * Test "queue" property adding at the end and removing from the front is
	 * First In, First Out (using addLast and removeFirst)
	 */
	@Test
	public void test04() {
		for(int i = 1; i <= 5; i++) {
			q.addLast(i);
			assertEquals(false, q.isEmpty());
			assertEquals(i, q.size());
		}
		for(int i = 1; i <= 5; i++) {
			assertEquals(false, q.isEmpty());
			assertEquals(i,  (int) q.removeFirst());
		}
		assertEquals(true, q.isEmpty());
	}
	
	/**
	 * Test "stack" property at the beginning of the Deque; that adding and removing
	 * from the front is First In, Last Out (using addFirst and removeFirst) 
	 */
	@Test
	public void test05() {
		for(int i = 1; i <= 5; i++) {
			q.addFirst(i);
			assertEquals(i, (int) q.removeFirst());
		}
	}
	
	/**
	 * Test "queue" property adding at the front and removing from the end is
	 * First In, First Out (using addFirst and removeLast)
	 */
	@Test
	public void test06() {
		for(int i = 1; i <= 5; i++) {
			q.addFirst(i);
		}
		for(int i = 1; i <= 5; i++) {
			assertEquals(i, (int) q.removeLast());
		}
	}

	/**
	 * Test addLast to add elements and then test iterator()
	 */
	@Test
	public void test07() {
		for(int i = 1; i <= 5; i++) {
			q.addLast(i);
		}
		assertEquals(5, q.size());
		Iterator<Integer> it = q.iterator();
		int i = 1;
		while(it.hasNext()) {
			assertEquals(i, (int) it.next());
			i++;
		}
		assertEquals(6, i);
		assertEquals(5, q.size());
	}

	/**
	 * Test 2 iterators for the same Deque are independent; each
	 * iterator keeps track of its own position in the same Deque, not affecting
	 * the other iterator.
	 */
	@Test
	public void test08()
	{
		for(int i = 1; i <= 5; i++) {
			q.addLast(i);
		}
		Iterator<Integer> it1 = q.iterator();
		Iterator<Integer> it2 = q.iterator();

		int y1 = it1.next();
		int y2 = it2.next();
		assertEquals(1, y1);
		assertEquals(1, y2);
		y1 = it1.next();
		y2 = it2.next();
		assertEquals(2, y1);
		assertEquals(2, y2);
	}

	/**
	 * Test iterator() after using addLast and removeFirst have modified an
	 * initially empty Deque.
	 */
	@Test
	public void test09() {
		for(int i = 1; i <= 5; i++) {
			q.addLast(i);
		}

		int x = q.removeFirst();
		Iterator<Integer> it = q.iterator();

		assertEquals(true, it.hasNext());
		int y = it.next();
		assertEquals(2, y);	
	}

	/**
	 * Test that the iterator next() method throws NoSuchElementException
	 * if the iterator's hasNext() method is false.
	 */
	@Test(expected=NoSuchElementException.class)
	public void test10() {
		Iterator<Integer> it;
		it = q.iterator();
		int x = it.next();
	}

	/**
	 * Test that the Iterator returned by iterator() either 
	 * (1) throws UnsupportedOperationException (to indicate not really implemented), or
	 * (2) is implemented to return the last element returned by next().
	 */
	@Test
	public void test11() {
		q.addLast(5);
		Iterator<Integer> it = q.iterator();
		int y = it.next();
		assertEquals(5, y);
		try {
			it.remove();
			assertEquals(true, q.isEmpty());
			assertEquals(0, q.size());
		} catch(UnsupportedOperationException e) {
			// Ok. remove is optional; if not implemented throws this exception
		} catch(Exception e) {
			fail("Expected remove to be implemented or to throw UnsupportedOperationException");
		}
	}

	/**
	 * Test that addLast throws a NullPointerException if an attempt is made to add the value null 
	 * to the end of the Deque.
	 */
	@Test(expected=NullPointerException.class)
	public void test12()
	{
		q.addLast(null);
	}
	
	/**
	 * Test that addFirst throws a NullPointerException if an attempt is made to add the value null
	 * to the beginning of the Deque.
	 */
	@Test(expected=NullPointerException.class)
	public void test13()
	{
		q.addFirst(null);
	}

	/**
	 * Test that removeFirst throws NoSuchElementException if the Deque is empty
	 */
	@Test(expected=NoSuchElementException.class)
	public void test14()
	{
		q.removeFirst();
	}
	
	/**
	 * Test that removeLast throws NoSuchElementException if the Deque is empty
	 */
	@Test(expected=NoSuchElementException.class)
	public void test15()
	{
		q.removeLast();
	}
}
