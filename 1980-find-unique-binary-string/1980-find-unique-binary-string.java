class Solution {
    public String numToBinary(int n){
        String s = "";
        while(n>0)
        {
            s = (n%2+"")+s;
            n = n/2;
        }
        return s;
    }
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<String> set = new HashSet<>();
        for(String s: nums) set.add(s);
        int last = (int)Math.pow(2,n);
        String zero = "";
        String nth = ""; 
        for(int i = 0 ; i<n ; i++){
            zero+='0';
            nth+='1';
        }
        if(!set.contains(zero)) return zero;
        if(!set.contains(nth)) return nth;
        for(int i = 1; i<last ; i++){
            String gen = numToBinary(i);
            if(gen.length()<n){
                while(gen.length()!=n){
                    gen = '0'+gen;
                }
            }
            if(!set.contains(gen)) return gen;
        }
        return "";
    }
}