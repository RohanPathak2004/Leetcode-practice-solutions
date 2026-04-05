class Solution {
    public int mirrorFrequency(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0 ;i<n ; i++) map.compute(s.charAt(i),(key,val)->val==null?1:val+1);
        for(char ch:map.keySet()){
            char mirror;
            if(ch>='a'&&ch<='z'){
                mirror = (char)(97+Math.abs(ch-122)); 
            }else{
                mirror = (char)(48+Math.abs(ch-57));
            }
            // System.out.println(ch+" "+mirror+" "+map.get(ch)+" "+(map.containsKey(mirror)?map.get(mirror):null));
            if(map.containsKey(mirror)){
                    ans += Math.abs(map.get(ch)-map.get(mirror));
                map.put(ch,0);
                map.put(mirror,0);
            }else{
                ans+= map.get(ch);
                map.put(ch,0);
            }
        }
        return ans;
    }
}