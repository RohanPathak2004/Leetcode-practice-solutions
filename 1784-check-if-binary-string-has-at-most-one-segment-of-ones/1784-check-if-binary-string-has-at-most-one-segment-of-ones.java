class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        if(n==1&&s.charAt(0)=='1') return true; 
        int i = 0;
        int j = i;
        int count = 0;

        while(i<n){
            while(j<n&&s.charAt(j)=='1') j++;
            if(j-i>=1) count++;
            
            if(count>1) return false;
            i=j;
            while(i<n&&s.charAt(i)!='1') i++;
            j=i;
        }
        if(count>1) return false;

        return true;
    }
}