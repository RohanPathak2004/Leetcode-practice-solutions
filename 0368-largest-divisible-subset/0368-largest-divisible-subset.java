class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        var map = new HashMap<Integer,List<Integer>>();
        for(int i = 0; i<n ; i++) {
            var list = new ArrayList<Integer>();
            map.put(i,list);
            for(int j = 0; j<i ; j++) {
                if(nums[i]%nums[j] == 0){
                    if((map.get(j)).size()>map.get(i).size()) map.put(i,map.get(j));
                }
            }
            var newList = new ArrayList<Integer>(map.get(i));
            newList.add(nums[i]);
            map.put(i,newList);
            if(res.size()<map.get(i).size()) res = map.get(i);
        }
        return res;
    }
}