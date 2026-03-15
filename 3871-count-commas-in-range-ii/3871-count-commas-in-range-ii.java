class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long i = 1000;
        String s = n + "";
        int range = s.length();
        while (i < Math.pow(10,range)) {
            ans += (n - i) + 1;
            i *= 1000;
        }
        return ans;
    }
}