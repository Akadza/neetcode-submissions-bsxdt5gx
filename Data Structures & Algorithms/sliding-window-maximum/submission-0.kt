class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque = ArrayDeque<Int>()
        val result = IntArray(nums.size - k + 1)

        for (i in nums.indices) {
            while (deque.isNotEmpty() && deque.first() < i - k + 1) deque.removeFirst()
            while (deque.isNotEmpty() && nums[deque.last()] < nums[i]) deque.removeLast()
            deque.addLast(i)
            if (i >= k - 1) result[i - k + 1] = nums[deque.first()]
        }

        return result
    }
} 