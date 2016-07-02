import java.util.LinkedList;


public class Main {
	public static boolean isMatched(String expression){
		final String openning = "({[";
		final String closing = ")}]";
		Stack<Character> buffer = new LinkedStack<Character>();
		for(char c: expression.toCharArray()){
			if(openning.indexOf(c) != -1)
				buffer.push(c);
			else if (closing.indexOf(c) != -1) {
				if (buffer.isEmpty())
					return false;
				if (closing.indexOf(c) != openning.indexOf(buffer.pop()))
					return false;
			}
		}
		return buffer.isEmpty(); 
	}
	
	public static boolean isHTMLMatched(String html){
		Stack<String> buffer = new LinkedStack<String>();
		int j = html.indexOf('<');
		while (j != -1){
			int k = html.indexOf('>',j+1);
			if (k == -1)
				return false;
			String tag = html.substring(j+1,k);
			if(!tag.startsWith("/"))
				buffer.push(tag);
			else {
				if (buffer.isEmpty())
					return false;
				if (!tag.substring(1).equals(buffer.pop()))
					return false;
			}
			j = html.indexOf('<',k+1);
		}
		return buffer.isEmpty();
	}
	
	public static void main(String[] args){
		/** Stack Testing */
		Stack<Integer> s1 = new ArrayStack<Integer>();
		Stack<Integer> s2 = new LinkedStack<Integer>();
		java.util.Stack s3 = new java.util.Stack();
		
		String str1 = "(((())))";
		String str2 = "(((()){{}}";
		String str3 = "<html>aaa</html>";
		String str4 = "<html>aaa</body>";
		System.out.println(isMatched(str1));
		System.out.println(isMatched(str2));
		System.out.println(isHTMLMatched(str3));
		System.out.println(isHTMLMatched(str4));
		
		/** Queue Testing */
		java.util.Queue q1 = new LinkedList();
		ArrayQueue<Integer> q2 = new ArrayQueue<Integer>();
		LinkedQueue<Integer> q3 = new LinkedQueue<Integer>();
		q1.add(1);
		
		/** Deque Testing */
		java.util.Deque dq = new java.util.ArrayDeque();
		dq.offerFirst(1);
		System.out.println(dq.size());
		System.out.println(dq.isEmpty());
		
	}
}
