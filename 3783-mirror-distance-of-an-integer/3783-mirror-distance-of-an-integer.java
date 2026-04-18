class Solution {
    public int revNum(int n){
        int r = 0;
        while(n!=0){
            int rem = n%10;
            n = n/10;
            r = r*10+rem;
        }
        return r;
    }
    public int mirrorDistance(int n) {
        int rev = revNum(n);
        return Math.abs(n-rev);
    }
}