class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int n = s.size();
        int i = 0,j = 0,maxLen = 0,cost = 0;

        while(j<n) {
            cost += abs((int)s[j]-(int)t[j]);
            while(i<=j&&cost>maxCost) {
                cost -= abs((int)s[i]-(int)t[i]);
                i++;
            }
            maxLen = max(j-i+1,maxLen);
            j++;
        }        
        return maxLen;

    }
};