class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i<nums.length-2 ; i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            int tar = nums[i]*(-1);
            for(int j = i+1 ; j<n ; j++){
                int remaining = tar-nums[j];
                if(map.containsKey(remaining)){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(remaining);
                     list.add(nums[j]);
                    Collections.sort(list);
                    set.add(list);
                    map.remove(remaining);
                }else{
                    map.put(nums[j],j);
                }
            }
        }
        for(List<Integer> list:set){
            ans.add(list);
        }
        return ans;
    }
}