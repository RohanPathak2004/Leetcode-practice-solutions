class Solution {
    public boolean isSequence(String str,String s){
        int i = 0;
        int j = 0;
        while(i<str.length()&&j<s.length()){
            if(str.charAt(i)==s.charAt(j)){
                i++;
            }
            j++;
        }
        if(j>=s.length()&&i<=str.length()-1) return false;
        return true;
    }
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        int count = 0;
        for(String str:words){
            map.compute(str,(key,value)->value==null?1:value+1);
        }
        for(String str:map.keySet()){
            if(isSequence(str,s)) count+=map.get(str);
        }
        return count;
    }
}