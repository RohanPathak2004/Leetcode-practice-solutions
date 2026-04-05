class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer> ans = new ArrayList<>();
        // System.out.println((int)Math.cbrt(n));
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = (int) Math.cbrt(n);
        // int[] nums = new int[n];
        for (int i = 1; i <= len; i++) {
            for (int j = i ; j <= len; j++) {
                int sum = i*i*i + j*j*j;
                if (sum <= n) {
                    map.compute(sum, (k, v) -> v == null ? 1 : v + 1);
                    if (map.get(sum) >= 2) {
                        map.put(sum,0);
                        ans.add(sum);
                    }

                }
                ;
            }
        }
        // for(int key:map.keySet()){
        //     if(map.get(key)>=2) ans.add(key);
        // }
        Collections.sort(ans);
        return ans;
    }
}