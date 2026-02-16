class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int maxPro = Integer.MIN_VALUE;
        pre[0] = nums[0];
        for (int i = 1; i < n ; i++) {
            if (nums[i] != 0)
                pre[i] = nums[i] * pre[i - 1];
            if (pre[i - 1] == 0)
                pre[i] = nums[i];

        }
        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] != 0)
                suf[i] = suf[i + 1] * nums[i];
            if (suf[i + 1] == 0)
                suf[i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            maxPro = Math.max(maxPro, Math.max(pre[i], suf[i]));
        }
        return maxPro;
    }
}