class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> baskets = new HashMap<>();
        int n = fruits.length;
        int i = 0;
        int j = 0;
        int maxF = 0;
        while(j<n)
        {
            int count = 0;
            baskets.compute(fruits[j],(key,val)->val==null?1:val+1);
            while(i<n&&baskets.size()>2){
                baskets.put(fruits[i],baskets.get(fruits[i])-1);
                if(baskets.get(fruits[i])==0) baskets.remove(fruits[i]);
                i++;
            }
            for(int key:baskets.keySet()){
                count+=baskets.get(key);
            }
            maxF = Math.max(maxF,count);
            j++;
        }
        return maxF;
    }
}