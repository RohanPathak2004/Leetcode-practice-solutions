class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        HashMap<Integer,Integer> last = new HashMap<>();
        HashMap<Integer,Integer> first = new HashMap<>();
        for(int i = 0; i< n ; i++){
            if(!first.containsKey(colors[i])){
                first.put(colors[i],i);
            }
        }
        if(first.size()==n) return n-1;

        int max = 0;
        for(int i = n-1 ; i>=0 ; i-- ){
            if(!last.containsKey(colors[i])){
                last.put(colors[i],i);
            }
        }
        for(int x:first.keySet()){
            for(int y:last.keySet()){
               if(x!=y){ max = Math.max(max,Math.abs(first.get(x)-last.get(y)));
                max = Math.max(max,Math.abs(first.get(y)-last.get(x)));}
            }
        }
        return max;
    }
}