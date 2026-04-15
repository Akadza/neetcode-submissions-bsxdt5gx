class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n)

        var factor = 1
        for (i in nums.indices) {
            val temp = nums[i]
            result[i] = factor
            factor *= nums[i] 
        }

        factor = 1
        for (i in n - 1 downTo 0) {
            val temp = nums[i]
            result[i] *= factor
            factor *= nums[i]
        }
        return result
    }
}
