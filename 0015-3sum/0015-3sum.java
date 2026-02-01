class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0 ; i<n-2 ; i++){
            int tar = nums[i]*(-1);
            int  j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[j]+nums[k];
                if(sum==tar){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    if(nums[j]==nums[j+1]||nums[k]==nums[k-1]){
                         while(j<n-1&&nums[j]==nums[j+1]) j++;
                         while(k>0&&nums[k]==nums[k-1]) k--;
                    }
                    j++;
                    k--;

                }else if(sum>tar){
                    k--;
                }else{
                    j++;
                }
            }
            while(i<n-1&&nums[i]==nums[i+1]) i++;
        }
        return ans;
    }
}