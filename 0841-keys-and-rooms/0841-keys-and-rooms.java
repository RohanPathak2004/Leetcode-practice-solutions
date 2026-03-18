class Solution {
    public void dfs(int room,boolean[] visited,List<List<Integer>> rooms){
        if(visited[room]) return;
        visited[room] = true;
        for(int ele: rooms.get(room)){
            dfs(ele,visited,rooms);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0,visited,rooms);
        for(boolean flag: visited) if(!flag) return false;
        return true;
    }
}