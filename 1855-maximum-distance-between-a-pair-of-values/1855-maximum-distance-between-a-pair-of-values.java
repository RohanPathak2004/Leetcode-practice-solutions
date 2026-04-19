class Solution {
    public boolean valid(int i,int j,int[] nums1, int[] nums2){
        return (j >= i && nums2[j] >= nums1[i]);
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < n && j < m) {
            if (valid(i,j,nums1,nums2)) {
                max = Math.max(max, j - i);
                j++;
            } else {
                while(i<n&&i<j&&!valid(i,j,nums1,nums2)){
                    i++;
                }
                if(i<n&&!valid(i,j,nums1,nums2)){
                    i=j;
                    j++;
                    i++;
                }
            }
        }
        
        return max;
    }
}