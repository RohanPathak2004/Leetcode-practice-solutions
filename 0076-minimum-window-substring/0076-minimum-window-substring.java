class Solution {
    public boolean isValidWindow(Map<Character,Integer> t_map,Map<Character,Integer> s_map){

        for(char key:t_map.keySet()){
            if(!s_map.containsKey(key)||s_map.get(key)<t_map.get(key)) return false;
        }

        return true;
    }
    public String minWindow(String s, String t) {
        Map<Character,Integer> t_map = new HashMap<>();
        Map<Character,Integer> s_map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i<t.length() ; i++){
            t_map.merge(t.charAt(i),1,Integer::sum);
        }
        int i = 0;
        int j = 0;
        int minSize = Integer.MAX_VALUE;
        String str = "";
        while(j<n){
            char ch = s.charAt(j);
            s_map.merge(ch,1,Integer::sum);
            if(s_map.size()>=t_map.size()){
                if(isValidWindow(t_map,s_map)){
                    // minSize = Math.min(minSize,j-i+1);
                    while(isValidWindow(t_map,s_map)){
                        if(minSize>=j-i+1){
                            minSize = Math.min(minSize,j-i+1);
                            str = s.substring(i,j+1);
                        }
                        s_map.put(s.charAt(i),s_map.get(s.charAt(i))-1);
                        if(s_map.get(s.charAt(i))==0) s_map.remove(s.charAt(i));
                        i++;
                    }
                }
            }
            j++;

        }
        return str;
    }
}