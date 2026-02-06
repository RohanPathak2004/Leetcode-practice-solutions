class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character,Integer> pMap = new HashMap<>();
        HashMap<Character,Integer> sMap = new HashMap<>();
        int n = s.length();
        int m = p.length();
        if(m>n) return ans;
        
        for(int i = 0; i<m ; i++){
            pMap.compute(p.charAt(i),(key,value)->value==null?1:value+1);
        }
        int i = 0;
        int j = 0;
        while(j<m){
            sMap.compute(s.charAt(j),(key,value)->value==null?1:value+1);
            j++;
        }
        j--;
        while(j<n){
            // System.out.println(i+" "+j);
            boolean flag = true;
            for(char ch:pMap.keySet()){
                
                if(sMap.containsKey(ch)){
                    if(!sMap.get(ch).equals(pMap.get(ch))){
                        flag = false;
                        break;
                    }
                }else{
                    flag = false;
                    break;
                }
            }
            // for(char ch:sMap.keySet()) System.out.println(ch+" "+sMap.get(ch));
            if(flag) ans.add(i);
            sMap.put(s.charAt(i),sMap.get(s.charAt(i))-1);
            if(sMap.get(s.charAt(i))==0) sMap.remove(s.charAt(i));
            i++;
            j++;
            if(j<n) sMap.compute(s.charAt(j),(k,v)->v==null?1:v+1);
        }
        return ans;
    }
}