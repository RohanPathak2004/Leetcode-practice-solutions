class Solution {
    record State(int node,int count, int cost){}
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++;
        var pq = new PriorityQueue<State>((a,b)->{
            int compare = Integer.compare(a.count,b.count);
            if(compare!=0) return compare;
            return Integer.compare(a.cost,b.cost);
        });
        var adj = new ArrayList<ArrayList<State>>();
        for(int i = 0; i<n ; i++) adj.add(new ArrayList<>());
        for(int i = 0; i<flights.length ; i++) {
            int[] edg = flights[i];
            int v1 = edg[0];
            int v2 = edg[1];
            int cost = edg[2];
            adj.get(v1).add(new State(v2,0,cost));
        }
        int[] res = new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[src] = 0;
        pq.add(new State(src,0,0));
        while(!pq.isEmpty()){
            State front = pq.poll();
            if(adj.get(front.node).isEmpty()) continue;
            for(State child: adj.get(front.node)) {
                int count = front.count+1;
                int cost = front.cost+child.cost;
                if(count<=k && cost < res[child.node]){
                    res[child.node] = cost;
                    pq.add(new State(child.node,count,cost));
                }
            }
        }
        // for(int ele: res) System.out.println(ele);
        return res[dst] == Integer.MAX_VALUE ? -1 : res[dst];
    }
}