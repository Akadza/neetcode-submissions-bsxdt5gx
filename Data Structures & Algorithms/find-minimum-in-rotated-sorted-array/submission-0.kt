class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val idx = left + (right - left) / 2
            if (nums[idx] <= nums[right]) right = idx
            else left = idx + 1
        }

        return nums[left]
    }
}