class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(i, j, board, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (word.charAt(index) == board[i][j]) {
            char original = board[i][j];
            board[i][j] = '*';
            if (dfs(i - 1, j, board, index + 1, word) || dfs(i, j + 1, board, index + 1, word) ||
                dfs(i + 1, j, board, index + 1, word)|| dfs(i, j - 1, board, index + 1, word)) {
                return true;
            }
            board[i][j] = original;   
        }

        return false;
    }
}
