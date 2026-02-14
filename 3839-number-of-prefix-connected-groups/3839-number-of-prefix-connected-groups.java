class Solution {
    public int prefixConnected(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        int n = words.length;
        int totalGrps = 0;
        for(int i = 0 ; i<n ; i++){
            String s = words[i];
            if(s.length()>=k){
                map.compute(s.substring(0,k),(key,val)->val==null?1:val+1);
            }
        }
        for(String key : map.keySet()){
            int freq = map.get(key);
            if(freq>1){
                totalGrps++;
            }
        }
        System.out.println(totalGrps);
        return totalGrps;
    }
}