class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] map = new int[2];
        int n = nums.length;
        int i = 0;
        int j = 0;
        int maxLen = 0;
        while (j < n) {
            map[nums[j]]++;
            if (map[0] <= k) {
                maxLen = Math.max(j - i + 1, maxLen);
            } else {
                while (map[0] > k) {
                    map[nums[i]]--;
                    i++;
                }
                maxLen = Math.max(j - i + 1, maxLen);
            }
            j++;
        }
        return maxLen;
    }
}