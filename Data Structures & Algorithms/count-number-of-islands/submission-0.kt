class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var amount = 0
        val row = grid.size
        val col = grid[0].size
        
        fun dfs(i: Int, j: Int) {
            if (i < 0 || j < 0 || i >= row || j >= col 
            || grid[i][j] == '0' || grid[i][j] == '#') {
                return
            }

            grid[i][j] = '#'
            dfs(i + 1, j)
            dfs(i - 1, j)
            dfs(i, j + 1)
            dfs(i, j - 1)
        }

        for (i in 0 until row) {
            for (j in 0 until col) {
                if (grid[i][j] == '1') {
                    amount++
                    dfs(i, j)
                }
            }
        }
        return amount
    }
}
