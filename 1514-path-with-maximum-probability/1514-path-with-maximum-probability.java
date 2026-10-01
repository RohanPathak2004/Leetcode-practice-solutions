class Solution {
    private record State(int node, double prob){}
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        var adj = new ArrayList<ArrayList<State>>();
        var pq = new PriorityQueue<State>((s1,s2)->Double.compare(s2.prob,s1.prob));
        for(int i = 0; i<n ; i++) adj.add(new ArrayList<>());
        for(int i = 0; i<edges.length ; i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            double prob = succProb[i];
            State state = new State(v2,prob);
            adj.get(v1).add(state);
            adj.get(v2).add(new State(v1,prob));
        }
        double[] res = new double[n];
        Arrays.fill(res,0);
        res[start_node] = 1;
        pq.add(new State(start_node,1));
        while(!pq.isEmpty()){
            State front = pq.poll();
            if(adj.get(front.node).size() == 0 || (front.prob<res[front.node])) continue;
            for(State child : adj.get(front.node)) {
                double totalP = front.prob * child.prob;
                if(totalP > res[child.node]){
                    res[child.node] = totalP; 
                    State s = new State(child.node,totalP);
                    pq.add(s);

                }
            }
        }


        return res[end_node];
    }
}