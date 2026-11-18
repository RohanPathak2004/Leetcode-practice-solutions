class Solution {
public:
    int dp[1001][1001];
    bool isPal(int i, int j, string& s){
        if(i>j) return true;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s[i] == s[j]) return dp [i][j] = isPal(i+1,j-1,s);
        return dp[i][j] = false;
    }
    string longestPalindrome(string s) {
        int n = s.size();
        memset(dp,-1,sizeof(dp));
        int maxLen = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i<n ; i++) {
            for(int j = i ; j<n ; j++) {
                if(isPal(i,j,s)){
                    if(j-i+1>maxLen){
                        start = i;
                        end = j;
                        maxLen = j-i+1;
                    }
                }
            }
        }
        return s.substr(start,end-start+1);
    }
};