class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        var first = new StringBuilder(".");
        var last = new StringBuilder(".");
        for(int i = 1 ; i<n ; i++){ 
            first.append('#');
            last.append('.');
        }
        ans[m-1] = last.toString();
        String frstS = first.toString();
        for(int i = 0; i<m-1 ; i++) {
            ans[i] = frstS;
        }
        return ans;
    }
}