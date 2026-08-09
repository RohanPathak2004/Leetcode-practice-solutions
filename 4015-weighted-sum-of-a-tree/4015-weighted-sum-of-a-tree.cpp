class Solution {
public:
    int h = 0;
    long long calW(int node,int d,vector<vector<int>>& adj,vector<int>& nums) {
        long long val = nums[node];
        long long cons = (h-d+1);
        long long totalW = val*(cons);
        for(auto& child:adj[node]) {
                totalW += calW(child,d+1,adj,nums);
        }
        return totalW;
    }
    int calH(int node,vector<vector<int>>& adj) {
        int maxH = 0;
        for(auto& child:adj[node]) {
                maxH = max(maxH,calH(child,adj));
        }
        return 1+maxH;
    }
    long long weightedSum(vector<int>& parent, vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> adj(n,vector<int>(0,0));
        for(int i = 1; i<n ; i++) {
            int p = parent[i];
            int c = i;
            adj[p].push_back(i);
        }
        h = calH(0,adj);
        long long w = calW(0,1,adj,nums);
        return w;
    }
};