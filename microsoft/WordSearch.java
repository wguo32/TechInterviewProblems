class Solution {
    int[] deltaX = {0, 1, 0, -1};
    int[] deltaY = {1, 0, -1, 0};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int m = board.length, n = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == chars[0]) {
                    if (search(board, i, j, chars, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, char[] chars, int index) {
        if (index == chars.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == chars[index]) {
            char mark = board[i][j];
            board[i][j] = '#';
            boolean find = search(board, i, j + 1, chars, index + 1) ||
                            search(board, i + 1, j, chars, index + 1) ||
                            search(board, i, j - 1, chars, index + 1) ||
                            search(board, i - 1, j, chars, index + 1);
            board[i][j] = mark;
            return find;
        }
        return false; // stop searching if current index already mismatch
    }
}
