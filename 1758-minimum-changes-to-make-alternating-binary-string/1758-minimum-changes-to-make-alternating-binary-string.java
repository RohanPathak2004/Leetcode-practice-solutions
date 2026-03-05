class Solution {
    public StringBuilder createString(char ch,int n){
        StringBuilder s = new StringBuilder(ch+"");
        for(int i = 1 ;i<n ; i++){
            if(s.charAt(i-1)=='1'){
                s.append('0');
            }else{
                s.append('1');
            }
        }
        return s;
    }
    public int minOperations(String s) {
        int n = s.length();
        if(n==1) return 0;
        char ch = s.charAt(0);
        String one = createString(ch,n).toString();
        String zero = createString(ch=='1'?'0':'1',n).toString();
        // System.out.println(one+" "+zero);
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i<n ; i++){
            if(s.charAt(i)!=one.charAt(i)) cnt1++;
            if(s.charAt(i)!=zero.charAt(i)) cnt2++;
        }

        return Math.min(cnt1,cnt2);
    }
}