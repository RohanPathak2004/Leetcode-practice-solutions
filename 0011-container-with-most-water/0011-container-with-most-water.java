class Solution {
    public int maxArea(int[] h) {
        int maxArea = 0;
        int n = h.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int smallH = Math.min(h[i], h[j]);
            int area = smallH * (j - i);
            maxArea = Math.max(area, maxArea);
            if (h[i] > h[j]) {
                j--;
            } else if (h[i] < h[j]) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return maxArea;
    }
}