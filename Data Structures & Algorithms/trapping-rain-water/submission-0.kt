class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var rightMax = 0
        var leftMax = 0
        var total = 0

        while (left < right) {
            val lh = height[left]
            val rh = height[right]
            if (lh < rh) {
                if (lh >= leftMax) leftMax = lh
                else total += leftMax - lh
                left++
            }
            else {
                if (rh >= rightMax) rightMax = rh
                else total += rightMax - rh
                right--
            }
        }
        return total
    }
}