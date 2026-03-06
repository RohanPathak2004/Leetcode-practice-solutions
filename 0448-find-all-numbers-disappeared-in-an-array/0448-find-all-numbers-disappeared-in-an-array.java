class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        List<Integer> list = new ArrayList<>();
        while(i<=j){
            int pos =nums[i]-1;
            if(pos<=n){
                if(nums[pos]==nums[i]) i++;
                else {
                    int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                }
            }else{
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        // for(int ele: nums) System.out.print(ele);
        for(int k = 0; k<n ;k++){
            if(nums[k]!=k+1) list.add(k+1);
        }
        return list;
    }
}