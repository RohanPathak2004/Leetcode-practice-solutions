class Solution {
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        int n = lst.length;
        int m = wst.length;
        // int[][] l = new int[n][2];
        // int[][] w = new int[m][2];
        // for (int i = 0; i < n; i++) {
        //     l[i][0] = lst[i];
        //     l[i][1] = ld[i];
        // }
        // for (int i = 0; i < m; i++) {
        //     w[i][0] = wst[i];
        //     w[i][1] = wd[i];
        // }
        
        int minT = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n ; i++){
            min = Math.min(min,lst[i]+ld[i]);
        }
        for(int i = 0; i<m ; i++){
            int t = min;
            if (t < wst[i]) {
                t += (wst[i] - t) + wd[i];
            } else {
                t += wd[i];
            }
            minT = Math.min(minT, t);
        }
        

        min = Integer.MAX_VALUE;
        for(int i = 0; i<m ; i++){
            min = Math.min(min,wst[i]+wd[i]);
        }
        for (int i = 0; i < n; i++) {
            int t = min;
            if (t < lst[i]) {
                t += (lst[i] - t) + ld[i];
            } else {
                t += ld[i];
            }
            minT = Math.min(minT,t);
        }
        
        return minT;
    }
}