class Solution {
    fun maxProduct(nums: IntArray): Int {
        var globalMax = nums[0]
        var curMax = nums[0]
        var curMin = nums[0]

        for (i in 1 until nums.size) {
            val num = nums[i]
            if (num < 0) curMin = curMax.also { curMax = curMin }
            curMin = minOf(num, curMin * num)
            curMax = maxOf(num, curMax * num)
            globalMax = maxOf(globalMax, curMax)
        }
        return globalMax
    }
}
