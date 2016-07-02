import java.util.ArrayList;

public class Solution {

    public static ArrayList<String> solve(ArrayList<String> data) {
        ArrayList<String> reverse = new	ArrayList<String>();
        for(int i = data.size()-1; i >= 0; i--){
        	reverse.add(data.get(i));
        }
    	return reverse;
    }
    
    public static void main(String args[]){
    	 ArrayList<String> data = new ArrayList<String>();
    	 ArrayList<String> reverse = new ArrayList<String>();
    	 data.add("Oh");
    	 data.add("Yeah");
    	 data.add("No");
    	 data.add("Way");
    	 reverse = Solution.solve(data);
    	 for(int i = 0; i < reverse.size(); i++)
    	 {
    		 System.out.println(reverse.get(i));
    	 }
    }
}