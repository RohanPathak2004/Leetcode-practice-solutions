class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {-1,-1};
        HashMap<Integer,Integer> map = new HashMap<>();
        //map.put(nums[0],1);
        for (int i = 0; i <nums.length ; i++) {
            int remaining = target-nums[i];
            if(map.containsKey(remaining)){
                ans[1] = map.get(remaining);
                ans[0] = i;
                break;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return ans;
    }
}