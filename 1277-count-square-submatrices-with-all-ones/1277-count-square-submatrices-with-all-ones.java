class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for(int i = 1; i<m ; i++){
            for(int j  =1 ; j<n ; j++){
                
                if(matrix[i][j]==1){
                    
                        matrix[i][j] += Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1]));
                    
                }
            }
        }
        for(int[] row: matrix){
            for(int ele: row) count+=ele;
            // System.out.println(" ");
        }
        return count;
    }
}