class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        var map = new HashMap<Character,Integer>();
        int  i = 0;
        int j = 0;
        int maxLen = 0;
        while(j<n) {
            char ch = s.charAt(j);
            int freq = map.merge(ch,1,Integer::sum);
            while(map.get(ch)>=2) {
                map.merge(s.charAt(i),-1,Integer::sum);
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}