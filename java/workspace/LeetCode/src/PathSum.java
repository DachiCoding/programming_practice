import java.util.ArrayList;
import java.util.List;


public class PathSum {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		System.out.println(allPath(n1));
	}
	
    public static List<List<Integer>> allPath(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        if(root.left == null && root.right == null){
            List<Integer> l = new ArrayList();
            l.add(root.val);
            result.add(l);
        } else {
            List<List<Integer>> lt = allPath(root.left);
            List<List<Integer>> rt = allPath(root.right);
            for(int i = 0; i < lt.size(); i++){
                lt.get(i).add(0,root.val);
            }
            for(int i = 0; i < rt.size(); i++){
                rt.get(i).add(0,root.val);
            }
        }
        return result;
    }
    
    public static boolean isEqual(List<Integer> list, int sum){
        int num = 0;
        for(int i = 0; i < list.size(); i++){
            num += list.get(i);
        }
        return num == sum;
    }
    
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        List<List<Integer>> allTree = allPath(root);
        for(int i = 0; i < allTree.size(); i++){
            List<Integer> l = allTree.get(i);
            if(isEqual(l,sum))
                result.add(l);
        }
        return result;
    }
}
