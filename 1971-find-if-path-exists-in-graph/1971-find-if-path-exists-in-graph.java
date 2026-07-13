class Solution {
    public boolean validPath(int n, int[][] eg, int src, int des) {
        if(src==des||eg.length==0) return true;
        // if(src==des) return true;
        boolean[] visited = new boolean[n];
        List<List<Integer>> grp = new ArrayList<>();
        for(int i = 0 ;i<n ; i++) grp.add(new ArrayList<>());
        for(int i = 0; i<eg.length ; i++){
            int x = eg[i][0];
            int y = eg[i][1];
            grp.get(x).add(y);
            grp.get(y).add(x);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = false;
        while(q.size()!=0){
            int front = q.remove();
            for(int ele:grp.get(front)){
                if(!visited[ele]){
                    if(ele==des) return true;
                    q.add(ele);
                    visited[ele] = true;
                }
            }
        }
        return false; 
    }
}