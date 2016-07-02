import java.awt.RenderingHints.Key;

public class SequentialSearchST {
  private int N;
  
  public int size(){
	  return this.N;
	  /*
	   * for(node x = first; x != null; x = x.next){
	   *   count++;
	   * }
	   * return count;
	   */
  }
  
  public void delete(Key key){
	  /*
	   * for(node x = first; x.next != null; x = x.next){
	   *   if(x.next.key == key){
	   *     x.next = x.next.next;
	   *   }
	   * }
	   * return count;
	   */ 
  }
  
  public <Iterable>Key keys(){
	  
  }
}
