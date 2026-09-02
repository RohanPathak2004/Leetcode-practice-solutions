class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length, i = 0, j = 1;
        int totalProfit = 0;
        while (j < n) {
            if (arr[j] > arr[i]) {
                totalProfit += arr[j] - arr[i];

            }
            i = j;
            j = i + 1;
        }
        return totalProfit;
    }
}