class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        
        while (left <= right) {
            val idx = left + (right - left) / 2
            
            if (nums[idx] == target) {
                return idx
            }
            
            if (nums[idx] > target) {
                right = idx - 1
            } else {
                left = idx + 1
            }
        }
        
        return -1
    }
}