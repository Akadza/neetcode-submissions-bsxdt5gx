class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { BooleanArray(9) }
        val cols = Array(9) { BooleanArray(9) }
        val boxes = Array(9) { BooleanArray(9) }

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val c = board[i][j]
                if (c == '.') continue

                val num = c - '1'
                val boxIndex = (i / 3) * 3 + (j / 3)

                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) return false

                rows[i][num] = true
                cols[j][num] = true
                boxes[boxIndex][num] = true
            }
        }
        return true
    }
}
