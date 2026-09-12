class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        int count = 0;
        var map = new HashMap<Integer,Integer>();
        for(int ele:nums) map.merge(ele,1,Integer::sum);
        for(int i = 1 ; i<n-1 ; i++) {
            if(map.get(nums[i]) == 3) {
                int x = i-1;
                int y = i+1;
                while(x>=0&&y<n&&nums[x]!=nums[i]&&nums[y]!=nums[i]){
                    x--;y++;
                }
                if(x>=0&&y<n&&nums[x]==nums[y]&&nums[x]==nums[i]){
                    if(i-x == y-i) count++;
                }
            }
        }
        return count;
    }
}