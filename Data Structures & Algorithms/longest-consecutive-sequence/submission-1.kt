class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val set = nums.toSet() 
        var longest = 0
        var length = 0
        for (num in set) {
            if (num - 1 !in set) {
                length = 1
                while (num + length in set) length++
                longest = maxOf(longest, length)
            }
        }
        return longest
    }
}