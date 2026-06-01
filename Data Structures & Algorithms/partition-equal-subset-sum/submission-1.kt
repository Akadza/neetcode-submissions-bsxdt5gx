class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val totalSum = nums.sum()
        if (totalSum % 2 == 1) return false
        val target = totalSum / 2

        val memo = BooleanArray(target + 1)
        memo[0] = true

        for (num in nums) {
            for (i in target downTo num) {
                if (memo[i - num]) memo[i] = true
            }
        }
        return memo[target]
    }
}
