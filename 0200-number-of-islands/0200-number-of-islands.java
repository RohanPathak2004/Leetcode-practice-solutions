class Solution {
    class Cell {
        int x;
        int y;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Cell))
                return false;
            Cell cell = (Cell) o;
            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int numIslands(char[][] grid) {
        HashMap<Cell, Set<Cell>> map = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Cell c = new Cell(i, j);
                    map.putIfAbsent(c, new HashSet<>());
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        Cell up = new Cell(i - 1, j);
                        map.computeIfAbsent(up, k -> new HashSet<>()).add(c);
                        map.computeIfAbsent(c, k -> new HashSet<>()).add(up);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        Cell down = new Cell(i + 1, j);
                        map.computeIfAbsent(down, k -> new HashSet<>()).add(c);
                        map.computeIfAbsent(c, k -> new HashSet<>()).add(down);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        Cell left = new Cell(i, j - 1);
                        map.computeIfAbsent(left, k -> new HashSet<>()).add(c);
                        map.computeIfAbsent(c, k -> new HashSet<>()).add(left);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        Cell right = new Cell(i, j + 1);
                        map.computeIfAbsent(right, k -> new HashSet<>()).add(c);
                        map.computeIfAbsent(c, k -> new HashSet<>()).add(right);
                    }
                }
            }
        }
        boolean[][] visited = new boolean[m][n];
        Queue<Cell> q = new LinkedList<>();
        // for (Cell c : map.keySet()) {
        //     System.out.println("key " + c.x + " " + c.y);
        //     Set<Cell> set = map.get(c);
        //     for (Cell v : set)
        //         System.out.println(" " + v.x + " " + v.y);
        // }

        int ans = 0;
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n ; j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                    ans++;
                    q.add(new Cell(i,j));
                    while(q.size()!=0){
                        Cell front = q.remove();
                        Set<Cell> s = map.get(front);
                        if(s==null) break;
                        for(Cell c: s){
                            if(!visited[c.x][c.y]){
                                 q.add(c);
                                 visited[c.x][c.y] = true;
                            }

                        }
                    }
                }
            }
        }

        return ans;
    }
}