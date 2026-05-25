class Solution {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        var left = 0
        var maxLen = 0

        for (i in s.indices) {

            check(s, i, i) { start, len ->
                if (len > maxLen) {
                    left = start
                    maxLen = len
                }
            }

            check(s, i, i + 1) { start, len ->
                if (len > maxLen) {
                    left = start
                    maxLen = len
                }
            }
        }
        return s.substring(left, left + maxLen)
    }

    private fun check(s: String, i: Int, j: Int, update: (Int, Int) -> Unit) {
        var l = i
        var r = j
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            update(l, r - l + 1)
            l--
            r++
        }
    }
}
