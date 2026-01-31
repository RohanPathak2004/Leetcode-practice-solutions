class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int [n+m];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<m&&j<n){
            if(nums1[i]>nums2[j]){
                merge[k++] = nums2[j++];
            }else{
                merge[k++] = nums1[i++];
            }
        }
        while(i<m) merge[k++] = nums1[i++];
        while(j<n) merge[k++] = nums2[j++];
        i=0;
        for(int ele:merge){
            nums1[i++] = ele;
        }
    }
}