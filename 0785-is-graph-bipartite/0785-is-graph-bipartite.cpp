class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        queue<int> q;
        int n = graph.size();
        vector<int> vis(n,-1);
        for(int i = 0; i<n ; i++) {
            if(vis[i] == -1) {
                q.push(i);
                vis[i] = 0;
                while(q.size()!=0) {
                    int front = q.front();
                    q.pop();
                    for(int ele : graph[front]) {
                        if(vis[ele] == vis[front]) return false;
                        if(vis[ele]==-1) {
                            q.push(ele);
                            vis[ele] = !vis[front];
                        }
                    }
                }
            }
        }
        return true;
    }
};