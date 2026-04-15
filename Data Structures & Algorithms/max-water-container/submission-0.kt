class Solution {
    fun maxArea(height: IntArray): Int {
        var result = 0
        var left = 0
        var right = height.size - 1
        while (left < right) {
            val hl = height[left]
            val hr = height[right]
            val s = (right - left) * minOf(hl, hr)
            result = maxOf(result, s)
            if (hl <= hr) left++
            if (hl > hr) right--
        }
        return result
    }
}