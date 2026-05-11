class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val rows = heights.size
        val cols = heights[0].size
        
        val pac = Array(rows) { BooleanArray(cols) }
        val atl = Array(rows) { BooleanArray(cols) }

        fun dfs(r: Int, c: Int, visit: Array<BooleanArray>, prevHeight: Int) {
            if (r < 0 || c < 0 || r >= rows || c >= cols || 
                visit[r][c] || heights[r][c] < prevHeight
            ) return

            visit[r][c] = true

            dfs(r + 1, c, visit, heights[r][c])
            dfs(r - 1, c, visit, heights[r][c])
            dfs(r, c + 1, visit, heights[r][c])
            dfs(r, c - 1, visit, heights[r][c])
        }

        for (c in 0 until cols) {
            dfs(0, c, pac, heights[0][c])
            dfs(rows - 1, c, atl, heights[rows - 1][c])
        }

        for (r in 0 until rows) {
            dfs(r, 0, pac, heights[r][0])
            dfs(r, cols - 1, atl, heights[r][cols - 1])
        }

        val result = ArrayList<List<Int>>()
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(listOf(r, c))
                }
            }
        }
        
        return result
    }
}