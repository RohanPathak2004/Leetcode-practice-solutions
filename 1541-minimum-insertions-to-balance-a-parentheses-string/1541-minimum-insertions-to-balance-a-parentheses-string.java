class Solution {
    public int minInsertions(String s) {
        int i = 0;
        int ins = 0;
        int count = 0;
        int n = s.length();
        while(i<n) {
            char ch = s.charAt(i);
            if(ch == '(') {
                count++;
                i++;
            }else {
                if(count>0) {
                    count--;
                }else {
                    ins++;
                }

                if(i+1<n && s.charAt(i+1) == ')') i+=2;
                else {
                    ins++;
                    i++;
                }
            }
        }

        return ins+(count*2);
    }
}