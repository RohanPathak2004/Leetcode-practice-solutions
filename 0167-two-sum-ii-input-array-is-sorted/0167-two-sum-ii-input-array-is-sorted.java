class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                ans[0] = i + 1;
                ans[1] = j + 1;
                return ans;
            }
        }
        return ans;
    }
}