class Solution {
    public int maximalSquare(char[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] matrix = new int[m][n];
        for(int i = 0; i<m ;i++){
            for(int j = 0; j<n ;j++){
                matrix[i][j] = (int)(arr[i][j]-48);
            }
        }
        for(int i = 1 ; i<m ; i++){
            for(int j = 1 ; j<n ; j++){
                if(matrix[i][j]!=0) matrix[i][j]+= Math.min(matrix[i-1][j],Math.min(matrix[i-1][j-1],matrix[i][j-1]));
            }
        }
        int max = 0;
        for(int[] r:matrix){
            for(int ele: r) max = Math.max(max,ele);
        }
        return max*max;
    }
}