class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val memo = IntArray(n) { -1 }

        fun dfs(i: Int): Int {
            if (memo[i] != -1) return memo[i]
            
            var lis = 1
            for (j in i + 1 until n) {
                if (nums[i] < nums[j]) {
                    lis = maxOf(lis, 1 + dfs(j))
                }
            }
            memo[i] = lis
            return lis
        }

        var maxSub = 1
        for (i in 0 until n) maxSub = maxOf(maxSub, dfs(i))
        return maxSub
    }
}
