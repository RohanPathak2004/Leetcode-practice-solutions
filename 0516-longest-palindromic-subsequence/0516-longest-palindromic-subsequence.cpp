class Solution {
public:
    int dp[1001][1001];
    int lcs(int i,int j,string& s,string& rev){
        if(i>=s.size()||j>=rev.size()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s[i] == rev[j]) return dp[i][j] = 1+lcs(i+1,j+1,s,rev);
        else return dp[i][j] = max(lcs(i+1,j,s,rev),lcs(i,j+1,s,rev));
    }
    int longestPalindromeSubseq(string s) {
        string rev = s;
        memset(dp,-1,sizeof(dp));
        reverse(rev.begin(),rev.end());
        return lcs(0,0,s,rev);
    }
};