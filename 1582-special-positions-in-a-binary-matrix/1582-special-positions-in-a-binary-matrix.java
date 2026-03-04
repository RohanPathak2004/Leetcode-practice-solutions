class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        for(int i = 0; i<m ; i++){
            for(int j = 0 ;j<n ;j++){
                rowSum[i]+=mat[i][j];
            }
        }

        for(int j = 0; j<n ;j++){
            for(int i = 0; i<m ;i++){
                colSum[j]+=mat[i][j];
            }
        }

        // for(int ele:rowSum) System.out.print(ele);
        // System.out.println(" ");
        // for(int ele:colSum) System.out.print(ele);
        int count = 0;
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ;j++){
                if(mat[i][j]==1&&rowSum[i]==1&&colSum[j]==1) count++;
            }
        }
        return count;
    }
}