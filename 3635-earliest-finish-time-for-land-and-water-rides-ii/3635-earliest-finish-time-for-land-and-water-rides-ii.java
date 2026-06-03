class Solution {
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        int n = lst.length;
        int m = wst.length;
        int[][] l = new int[n][2];
        int[][] w = new int[m][2];
        for (int i = 0; i < n; i++) {
            l[i][0] = lst[i];
            l[i][1] = ld[i];
        }
        for (int i = 0; i < m; i++) {
            w[i][0] = wst[i];
            w[i][1] = wd[i];
        }
        
        int minT = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n ; i++){
            min = Math.min(min,l[i][0]+l[i][1]);
        }
        for(int i = 0; i<m ; i++){
            int t = min;
            if (t < w[i][0]) {
                t += (w[i][0] - t) + w[i][1];
            } else {
                t += w[i][1];
            }
            minT = Math.min(minT, t);
        }
        

        min = Integer.MAX_VALUE;
        for(int i = 0; i<m ; i++){
            min = Math.min(min,w[i][0]+w[i][1]);
        }
        for (int i = 0; i < n; i++) {
            int t = min;
            if (t < l[i][0]) {
                t += (l[i][0] - t) + l[i][1];
            } else {
                t += l[i][1];
            }
            minT = Math.min(minT,t);
        }
        
        return minT;
    }
}