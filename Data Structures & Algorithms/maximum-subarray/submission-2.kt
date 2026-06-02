class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val dp = nums.copyOf()
        for (i in 1 until nums.size) {
            dp[i] = maxOf(nums[i], nums[i] + dp[i - 1])
        }
        return dp.maxOrNull() ?: nums[0]
    }
}
