
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	
        if (m == 0){
            nums1 = nums2;
            return;
        }
        
        if (n == 0){
            return;
        }
        
        int[] aux = new int[nums1.length];
        int i = 0;
        int j = 0;
        
        for(int k = 0; i <= m && j <= n; k++){
            if(i >= m){
                aux[k] = nums2[j];
                j++;
            } else if (j >= n){
                aux[k] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]){
                aux[k] = nums1[i];
                i++;
            } else {
                aux[k] = nums2[j];
                j++;
            }
        }
        
        nums1 = aux;
    }
}
