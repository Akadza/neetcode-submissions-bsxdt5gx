class Solution {
    fun canJump(nums: IntArray): Boolean {
        val n = nums.size
        val memo = BooleanArray(n) { false }
        memo[n - 1] = true

        for (i in n - 2 downTo 0) {
            val end = minOf(n, i + nums[i] + 1)
            for (j in i + 1 until end) {
                if (memo[j]) {
                    memo[i] = true
                    break
                }
            }
        }
        return memo[0]
    }
}
