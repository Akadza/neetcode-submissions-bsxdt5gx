class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) return false
        val m = matrix.size
        val n = matrix[0].size
        var left = 0
        var right = m * n - 1
        while(left <= right) {
            val idx = left + (right - left) / 2
            val valueIdx = matrix[idx / n][idx % n]
            if (valueIdx == target) return true
            if (valueIdx > target) right = idx - 1
            else left = idx + 1
        }
        return false
    }
}
