class Solution {
    fun solve(board: Array<CharArray>) {
        val rows = board.size
        val cols = board[0].size
        
        fun dfs(i: Int, j: Int) {
            if (i !in 0 until rows || j !in 0 until cols || board[i][j] != 'O') {
                return
            }

            board[i][j] = '#'
            dfs(i + 1, j)
            dfs(i + -1, j)
            dfs(i, j + 1)
            dfs(i, j - 1)
        }

        for (i in 0 until rows) {
            if (board[i][0] == 'O') dfs(i, 0)
            if (board[i][cols - 1] == 'O') dfs(i, cols - 1)
        }
        for (j in 0 until cols) {
            if (board[0][j] == 'O') dfs(0, j)
            if (board[rows - 1][j] == 'O') dfs(rows - 1, j)
        }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (board[i][j] == 'O') board[i][j] = 'X'
                if (board[i][j] == '#') board[i][j] = 'O'
            }
        }
    }
}
