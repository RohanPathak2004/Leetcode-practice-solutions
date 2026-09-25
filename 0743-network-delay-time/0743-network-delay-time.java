class Solution {
     record Pair(int node, int time) {
    }
    ArrayList<ArrayList<Pair>> generateAdj(int[][] edg,int n) {
        var adj = new ArrayList<ArrayList<Pair>>();
        for(int i = 0; i<n+1 ; i++) adj.add(new ArrayList<>());
        for(int i = 0; i<edg.length ; i++) {
            int start = edg[i][0];
            int end = edg[i][1];
            int time = edg[i][2];
            adj.get(start).add(new Pair(end,time));
        }
        return adj;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        var pq = new PriorityQueue<Pair>((p1, p2) -> Integer.compare(p1.time, p2.time));
        int[] costs = new int[n+1];
        Arrays.fill(costs,Integer.MAX_VALUE);
        costs[k] =0;
        var adj = generateAdj(times,n);
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()) {
            Pair front = pq.poll();
            if(costs[front.node]<front.time) continue;
            for(Pair child: adj.get(front.node)) {
                int totalTime = child.time+front.time;
                if(costs[child.node]>totalTime) {
                    costs[child.node] = totalTime;
                    pq.add(new Pair(child.node,totalTime));
                }
            }
        }
        
        // for(int ele: costs) System.out.println(ele);
        int ans = Integer.MIN_VALUE;
        for(int i = 1 ; i<=n ; i++) ans = Math.max(ans,costs[i]);
        return ans == Integer.MAX_VALUE? -1 : ans;
    }
}