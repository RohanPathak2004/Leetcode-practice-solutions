class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;
        int i = 0;
        int j = i;
        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<n)
        {
            int len =1;
            
            while(j<n&&!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),j);
                j++;
            }
            len = j-i;
            maxLen = Math.max(len,maxLen);
            if(j<n&&map.containsKey(s.charAt(j))){
                i = map.get(s.charAt(j))+1;
            }
            
            Iterator<Character> iterator = map.keySet().iterator();

            while(iterator.hasNext()){
                Character ch = iterator.next();
                if(map.get(ch)<i) iterator.remove();
            }

        }
        return maxLen;
    }
}