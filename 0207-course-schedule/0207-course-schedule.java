class Solution {
    public boolean canFinish(int n, int[][] pr) {
        var adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<n ; i++) adj.add(new ArrayList<>());
        for(int[] p: pr) {
            int a = p[0];
            int b = p[1];
            adj.get(b).add(a);
        }
        int count = 0;
        int[] in = new int[n];
        var queue = new LinkedList<Integer>();
        for(int i = 0 ; i<n ; i++) {
            var list = adj.get(i);
            for(int ele: list) in[ele]++;
        }
        for(int i = 0; i<n ; i++) if(in[i] == 0) queue.add(i);
        while(!queue.isEmpty()) {
            int front = queue.remove();
            count++;
            for(int node: adj.get(front)) {
                in[node]--;
                if(in[node] == 0) queue.add(node);
            }
        }

        return (count == n);
    }
}