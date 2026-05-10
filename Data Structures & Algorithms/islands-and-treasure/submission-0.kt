class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) { 
        val directions = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
        val queue = ArrayDeque<Pair<Int, Int>>()
        val rows = grid.size
        val cols = grid[0].size

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == 0) queue.add(i to j)
            }
        }

        if (queue.isEmpty()) return

        while(queue.isNotEmpty()) {
            val (row, col) = queue.poll()
            for((r, c) in directions) {
                val nr = row + r
                val nc = col + c
                if (nr !in 0 until rows || nc !in 0 until cols || grid[nr][nc] != Int.MAX_VALUE) {
                    continue
                }
                queue.add(nr to nc)
                grid[nr][nc] = grid[row][col] + 1
            } 
        }
    }
}
