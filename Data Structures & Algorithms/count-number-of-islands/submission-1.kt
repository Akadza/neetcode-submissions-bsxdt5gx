class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0
        
        val rows = grid.size
        val cols = grid[0].size
        var islands = 0

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == '1') {
                    islands++
                    dfs(grid, r, c, rows, cols)
                }
            }
        }
        return islands
    }

    private fun dfs(grid: Array<CharArray>, r: Int, c: Int, rows: Int, cols: Int) {
        if (r !in 0 until rows || c !in 0 until cols || grid[r][c] != '1') {
            return
        }

        grid[r][c] = '0'

        dfs(grid, r + 1, c, rows, cols)
        dfs(grid, r - 1, c, rows, cols)
        dfs(grid, r, c + 1, rows, cols)
        dfs(grid, r, c - 1, rows, cols)
    }
}
