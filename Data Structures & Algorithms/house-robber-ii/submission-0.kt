class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return maxOf(
            solve(nums.sliceArray(0 until nums.size - 1)),
            solve(nums.sliceArray(1 until nums.size))
        )
    }

    private fun solve(nums: IntArray): Int {
        val memo = IntArray(nums.size) { -1 }

        fun dfs(i: Int): Int {
            if (i >= nums.size) return 0
            if (memo[i] != -1) return memo[i]
            
            memo[i] = maxOf(dfs(i + 1), nums[i] + dfs(i + 2))
            return memo[i]
        }

        return dfs(0)
    }
}
