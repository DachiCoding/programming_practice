import java.util.HashMap;
import java.util.Map;


public class StringAlgos {
	public static int findBrute(char[] text, char[] pattern){
		int n = text.length;
		int m = pattern.length;
		for(int i = 0; i <= n - m; i++){
			int k = 0;
			while(k < m && text[i+k] == pattern[k])
				k++;
			if(k == m)
				return i;
		}
		return -1;
	}
	
	public static int findBoyerMoore(char[] text, char[] pattern){
		int n = text.length;
		int m = pattern.length;
		if (m == 0) return 0;
		Map<Character, Integer> last = new HashMap<Character, Integer>();
		for (int i = 0; i < n; i++)
			last.put(text[i], -1);
		for (int k = 0; k < m; k++)
			last.put(pattern[k], k);
		int i = m - 1;
		int k = m - 1;
		while (i < n){
			if(text[i] == pattern[k]){
				if (k == 0) return i;
				i--;
				k--;
			} else {
				i += m - Math.min(k, 1 + last.get(text[i]));
				k = m - 1;
			}
		}
		return -1;
	}
	
	
	
	public static void main(String args[]){
		String text = new String("Hello,world!");
		char[] textArr = text.toCharArray();
		char[] pattern = {'w','o','r'}; 
		System.out.println(findBrute(textArr, pattern));
	}
}
