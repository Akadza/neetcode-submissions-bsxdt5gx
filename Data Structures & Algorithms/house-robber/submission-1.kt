class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n + 1) { -1 }
        fun dfs(i: Int): Int {
            if (i >= n) return 0
            if (dp[i] != -1) return dp[i]
            dp[i] = maxOf(dfs(i + 1), nums[i] + dfs(i + 2))
            return dp[i] 
        }
        return dfs(0)
    }
}
