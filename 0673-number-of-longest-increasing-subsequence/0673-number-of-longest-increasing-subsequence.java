class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int maxLen = 0;
        int[] lis = new int[n];
        int[] cnt = new int[n];
        lis[n-1] = 1;
        cnt[n-1] = 1;
        Arrays.fill(lis,1);
        Arrays.fill(cnt,1);
        for(int i = n-1; i>=0 ;i--){
            for(int j = i+1 ;j<n ;j++){
                if(nums[i]<nums[j]){
                    if(lis[i]==lis[j]+1) cnt[i]+=cnt[j];
                    else if(lis[i]<lis[j]+1){
                        lis[i] = lis[j]+1;
                        cnt[i] = cnt[j];
                    }
                }
            }
        }
        for(int ele: lis){
            maxLen = Math.max(maxLen,ele);
        }
        if(maxLen==1) return n;

        for(int i = 0 ;i<n ;i++){
            if(lis[i]==maxLen) ans+=cnt[i];
        }
        return ans;
    
    }
}