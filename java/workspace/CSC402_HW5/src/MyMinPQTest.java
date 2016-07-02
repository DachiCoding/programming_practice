import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;


public class MyMinPQTest {
	private MyMinPQ<Integer> pq;
	Integer[] a, b;
	@Before
	public void setup()
	{
		pq = new MyMinPQ<Integer>();
		a = new Integer[] {5,4,3,2,1,6,7,9,8};
		b = new Integer[] {5,4,3,2,1,1,1,1,1};
	}
	
	@Test
	public void test() {
		assertEquals(0, pq.size());
	}
	
	@Test
	public void test1()
	{
		pq.insert(5);
		assertEquals(5, (int) pq.min());
		pq.insert(4);
		assertEquals(4, (int) pq.min());
		pq.insert(6);
		assertEquals(4, (int) pq.min());
		assertEquals(3, pq.size());
	}
	
	@Test
	public void test2()
	{
		for(int i = 0; i < a.length; i++) {
			pq.insert(a[i]);
			assertEquals(i + 1, pq.size());
			assertEquals(b[i], pq.min());
		}
	}
	
	@Test
	public void test3()
	{
		for(int i = 0; i < a.length; i++) {
			pq.insert(a[i]);
		}
		for(int i = 0; i < a.length; i++) {
			assertEquals(i + 1, (int) pq.delMin());
		}
		assertEquals(0, pq.size());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void test4()
	{
		pq.delMin();
	}
	
	@Test
	public void test5() {
		for(int i = 0; i < a.length; i++) {
			pq.insert(a[i]);
		}
		Iterator<Integer> it = pq.iterator();
		int count = 0;
		while(it.hasNext()) {
			assertEquals( true, Arrays.binarySearch(a, it.next()) != -1);
			count++;
		}
		assertEquals(count, a.length);
	}

}
