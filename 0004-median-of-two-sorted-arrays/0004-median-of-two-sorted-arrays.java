class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] nums = new int[n+m];
        int i = 0,j=0,k=0;
        while(i<n&&j<m) {
            if(nums1[i]>=nums2[j]) {
                nums[k++] = nums2[j++];
            }else{
                nums[k++] = nums1[i++];
            }
        }
        while(i<n) {
            nums[k++] = nums1[i++];
        }
        while(j<m) nums[k++] = nums2[j++];
        int mid = nums.length/2;
        if(nums.length%2 == 1) {
            // System 
            return nums[mid];
        }
        double ele = nums[mid];
        double eleP = nums[mid-1];
        return (ele+eleP)/2;
    }
}