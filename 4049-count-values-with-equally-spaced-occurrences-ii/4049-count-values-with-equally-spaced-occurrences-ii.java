class Solution {
    public int countSpecialIntegers(int[] nums) {
        var diff = new HashMap<Integer,Integer>();
        var freq = new HashMap<Integer,Integer>();
        var idx = new HashMap<Integer,Integer>();
        var ign = new HashSet<Integer>();
        int count = 0;
        int n = nums.length;
        for(int i = 0; i<n ; i++) {
            if(diff.containsKey(nums[i])){

                if(diff.get(nums[i])==-1) {
                    int prevIdx = idx.get(nums[i]);
                    int diffIdx = i-prevIdx;
                    diff.put(nums[i],diffIdx);
                    freq.merge(nums[i],1,Integer::sum);
                    idx.put(nums[i],i);
                }else {
                    int prevIdx = idx.get(nums[i]);
                    int diffIdx = i-prevIdx;
                    if(diffIdx == diff.get(nums[i])){
                        diff.put(nums[i],diffIdx);
                    freq.merge(nums[i],1,Integer::sum);
                    idx.put(nums[i],i);
                    }else{
                        ign.add(nums[i]);
                    };
                }
                
            }else {
                diff.put(nums[i],-1);
                freq.put(nums[i],1);
                idx.put(nums[i],i);
            }
        }

        for(int key:diff.keySet()){
            if(!ign.contains(key)&&freq.get(key)>=3) count++;
        }

        return count;
    }
}