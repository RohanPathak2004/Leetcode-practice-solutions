class Solution {

    public StringBuilder rev(StringBuilder s){
       
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            char temp = s.charAt(i);
            s.setCharAt(i,s.charAt(j));
            s.setCharAt(j,temp);
            i++;
            j--;
        }
       return s;
    }

    public StringBuilder invert(StringBuilder s){
        
        for(int i = 0;i<s.length() ;i++){
            if(s.charAt(i)=='0') s.setCharAt(i,'1');
            else s.setCharAt(i,'0');
        }
        return s;
    }

    public StringBuilder rec(int n){
        if(n==1) return new StringBuilder("0");
       
        
        return rec(n-1).append("1").append(rev(invert(rec(n-1))));
    }

    public char findKthBit(int n, int k) {
        StringBuilder binary = rec(n);
       
        return binary.charAt(k-1);
    }
}