class Solution {
    public String mergeCharacters(String s, int k) {
        int n = s.length();
        if (n == 1)
            return s;
        List<Character> list = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        while (i < list.size()) {
            char ch = list.get(i);
            if (map.containsKey(ch)) {
                int dis = i - (map.get(ch));
                if (dis > k) {
                    map.put(ch, i);
                    i++;
                } else {
                    list.remove(i);

                }
            } else {
                map.put(ch, i);
                i++;
            }
        }
        String ans = "";
        for (char ch : list)
            ans += ch;
        return ans;
    }
}