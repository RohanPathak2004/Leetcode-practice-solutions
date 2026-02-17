class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxW = 0;
        while (i < n && j < n) {
            char ch = s.charAt(j);
            map.compute(ch, (key, val) -> val == null ? 1 : val + 1);
            int window = j - i + 1;
            int freq = 0;
            for (char c : map.keySet()) {
                freq = Math.max(freq, map.get(c));
            }

            while (i < n && (window - freq) > k) {

                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
                window = j - i + 1;
            }
            window = j - i + 1;
            maxW = Math.max(window, maxW);
            j++;
        }
        int window = j - i;
        maxW = Math.max(window, maxW);
        return maxW;
    }
}