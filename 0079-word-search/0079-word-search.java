class Solution {
    public boolean search(int i, int j, int m, int n, char[][] board, String word, int[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;
        if (word.length() == 0)
            return false;
        if (word.length() == 1) {

            if (board[i][j] == word.charAt(0)) {
                visited[i][j] = -1;
                return true;
            }
            visited[i][j] = 0;
            return false;
        }

        if (word.charAt(0) != board[i][j]) {
            visited[i][j] = 0;
            return false;
        }
        char up = (i - 1 >= 0) ? board[i - 1][j] : '$';
        char down = (i + 1 < m) ? board[i + 1][j] : '$';
        char left = (j - 1 >= 0) ? board[i][j - 1] : '$';
        char right = (j + 1 < n) ? board[i][j + 1] : '$';
        String newWord = (word.length() > 1) ? word.substring(1) : word;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        if (up != '$' && newWord.charAt(0) == up) {
            if (visited[i - 1][j] != -1) {
                visited[i - 1][j] = -1;
                flag1 = search(i - 1, j, m, n, board, newWord, visited);
            }
        }
        if (down != '$' && newWord.charAt(0) == down) {
            if (visited[i + 1][j] != -1) {
                visited[i + 1][j] = -1;
                flag2 = search(i + 1, j, m, n, board, newWord, visited);
            }
        }
        if (left != '$' && newWord.charAt(0) == left) {
            if (visited[i][j - 1] != -1) {
                visited[i][j - 1] = -1;
                flag3 = search(i, j - 1, m, n, board, newWord, visited);
            }
        }
        if (right != '$' && newWord.charAt(0) == right) {
            if (visited[i][j + 1] != -1) {
                visited[i][j + 1] = -1;
                flag4 = search(i, j + 1, m, n, board, newWord, visited);
            }
        }
        visited[i][j] = 0;
        return flag1 || flag2 || flag3 || flag4;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if (word.length() != 1 && word.length() > m * n)
            return false;

        for (int i = 0; i < m; i++) {
            int[][] visited = new int[m][n];
            for (int j = 0; j < n; j++) {
                char ch = word.charAt(0);
                boolean flag = false;
                if (board[i][j] == ch) {
                    visited[i][j] = -1;
                    flag = search(i, j, m, n, board, word, visited);
                }
                // System.out.println(flag);
                if (flag)
                    return true;
            }
        }

        return false;
    }
}