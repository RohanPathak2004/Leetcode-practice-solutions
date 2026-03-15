class Solution {
    public int findCircleNum(int[][] grh) {
        int n = grh.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                q.add(i);
                while (q.size() != 0) {
                    int node = q.remove();
                    for (int j = 0; j < n; j++) {
                        if (grh[node][j] == 1 && !visited[j]) {
                            // System.out.println(j);
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}