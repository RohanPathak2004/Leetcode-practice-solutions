class Solution {

    public void explore(int i,boolean[] visited,int[][] adj){
        if(visited[i]) return ;
        visited[i] = true;
        for(int j = 0 ;j<adj.length ; j++){
            if(adj[i][j]==1){
                
                explore(j,visited,adj);
            }
        }
    }

    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i<n ;i++){
            if(!visited[i]){
                count++;
                explore(i,visited,adj);
            }
        }

        return count;
    }
}