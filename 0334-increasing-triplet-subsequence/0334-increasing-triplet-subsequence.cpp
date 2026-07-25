class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int n = nums.size();
        if(n<3) return false;
        vector<int> minPref(n,0);
        vector<int> maxSuf(n,0);
        minPref[0] = nums[0];
        maxSuf[n-1] = nums[n-1];
        for(int i = 1 ; i<n ; i++) {
            minPref[i] = min(nums[i],minPref[i-1]);
        }
        for(int i = n-2 ; i>=0 ; i--) {
            maxSuf[i] = max(maxSuf[i+1],nums[i]);
        }
        for(int i = 0; i<n ; i++) {
            if(nums[i]>minPref[i]&&nums[i]<maxSuf[i]) return true;
        }
        return false;
    }
};