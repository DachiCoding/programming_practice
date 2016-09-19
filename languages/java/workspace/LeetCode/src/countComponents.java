import java.util.HashMap;
import java.util.Map;

public class countComponents {
	
	   static class ListNode {
	        public ListNode prev;
	        public ListNode next;
	        
	        public ListNode(){}
	    }
	    
	    public static int countComponents(int n, int[][] edges) {
	        /* 
	        n,
	        edges[n][2] = [
	          [a,b],[c,d],.....
	        ]
	        */
	        
	        if(edges == null || edges.length == 0){
	        	if(n != 0) return n;
	        	else return 0;
	        }
	        int comp = 0;
	        Map compMap = new HashMap();
	        
	        for(int i = 0; i < n; i++){
	            ListNode node = new ListNode();
	            compMap.put(i,node);
	        }
	        
	        for(int i = 0; i < edges.length; i++){
	            int[] edge = edges[i];
	            int n1 = edge[0];
	            int n2 = edge[1];
	            ListNode node1 = (ListNode) compMap.get(n1);
	            ListNode node2 = (ListNode) compMap.get(n2);
	            node1.next = node2;
	            node2.prev = node1;
	            compMap.put(n1,node1);
	            compMap.put(n2,node2);
	        }
	        
	        int conn = 0;
	        int uncn = 0;
	        
	        for(int i = 0; i < n; i++){
	            ListNode node = (ListNode) compMap.get(i);    
	            if(node.prev == null && node.next == null){
	                uncn++;
	            } else if (node.prev == null){
	                conn++;
	            }
	        }
	        
	        return conn+uncn;
	    }
	    
	    public static void main(String args[]){
			int[][] edeges = {};
			countComponents(1,edeges);
		}
		
}
