class Solution {
    public void dfs(int i,int j,int m,int n,boolean[][] visited,char[][] grid){
        if(i<0||i>=m||j<0||j>=n||visited[i][j]||grid[i][j]=='0') return;
        visited[i][j] = true;
        dfs(i-1,j,m,n,visited,grid);
        dfs(i+1,j,m,n,visited,grid);
        dfs(i,j-1,m,n,visited,grid);
        dfs(i,j+1,m,n,visited,grid);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n ;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                    count++;
                    dfs(i,j,m,n,visited,grid);
                    // System.out.println(visited[i][j]);
                }
            }
        }

        return count;
    }
}