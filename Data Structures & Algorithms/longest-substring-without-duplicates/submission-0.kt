class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val lastSeen = IntArray(128) { -1 }
        var left = 0
        var maxLen = 0
        
        for (right in s.indices) {
            val c = s[right].code
            if (lastSeen[c] >= left) {
                left = lastSeen[c] + 1
            }
            lastSeen[c] = right
            maxLen = maxOf(maxLen, right - left + 1)
        }
        return maxLen
    }
}