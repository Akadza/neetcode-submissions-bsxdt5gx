class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea = 0
        val directions = arrayOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        val row = grid.size
        val col = grid[0].size

        fun dfs(i: Int, j: Int): Int {
            if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1) {
                return 0
            }

            grid[i][j] = 0
            var area = 1

            for ((dr, dc) in directions) {
                area += dfs(i + dr, j + dc)
            }
            return area
        }

        for (i in 0 until row) {
            for (j in 0 until col) {
                maxArea = maxOf(maxArea, dfs(i, j))
            }
        }
        return maxArea
    }
}
