class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i<n ; i++){
            for(int j = 0; j<n ;j++){
                int top = matrix[i-1][j];
                int left = Integer.MAX_VALUE;
                int right = left;
                if(j-1>=0) left = matrix[i-1][j-1];
                if(j+1<=n-1) right = matrix[i-1][j+1];
                matrix[i][j] += Math.min(left,Math.min(top,right));
                
            }
        }
        for(int i = 0 ;i<n;i++) ans = Math.min(ans,matrix[n-1][i]);
        return ans;
    }
}