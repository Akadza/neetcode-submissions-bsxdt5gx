class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val directions = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
        val rows = grid.size
        val cols = grid[0].size

        var time = -1
        var countFresh = 0  

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == 2) queue.add(row to col)
                if (grid[row][col] == 1) countFresh++
            } 
        }

        if (countFresh == 0) return 0

        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val (row, col) = queue.poll()
                for ((r, c) in directions) {
                    val nr = r + row
                    val nc = c + col
                    if (nr !in 0 until rows || nc !in 0 until cols || grid[nr][nc] != 1) {
                        continue
                    }
                    queue.add(nr to nc)
                    grid[nr][nc] = 2
                    countFresh--
                }
            }
            time++
        }
        return if (countFresh == 0) time else -1
    }
}
