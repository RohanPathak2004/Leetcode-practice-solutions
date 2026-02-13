class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 2 pointer approach i and j sliding window
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxlen = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch) && map.get(ch) >= i) {
                int len = j - i;
                maxlen = Math.max(maxlen, len);
                while (s.charAt(i) != ch)
                    i++;
                i++;

            }
                
            map.put(ch, j);
            
            j++;
        }
        int len = j - i;
        maxlen = Math.max(maxlen, len);
        return maxlen;
    }
}