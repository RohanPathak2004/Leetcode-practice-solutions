class Solution {
public:
    int rec(int n, int m,string& w1,string& w2,vector<vector<int>>& dp){
        if(n<=0&&m<=0) return 0;
        if(n<=0) return m;
        if(m<=0) return n;
        if(dp[n][m]!=-1) return dp[n][m];
        if(w1[n-1] == w2[m-1]){
            return dp[n][m] =  rec(n-1,m-1,w1,w2,dp);
        }else{
            int d = rec(n-1,m,w1,w2,dp);
            int r = rec(n-1,m-1,w1,w2,dp);
            int i = rec(n,m-1,w1,w2,dp);
            return dp[n][m] = 1+min(d,min(i,r));
        }
    }
    int minDistance(string word1, string word2) {
        if(word1 == "") return word2.size();
        int n = word1.size();
        int m = word2.size();
        vector<vector<int>> dp(n+1,vector<int>(m+1,-1));
        return rec(word1.size(),word2.size(),word1,word2,dp);
    }
};