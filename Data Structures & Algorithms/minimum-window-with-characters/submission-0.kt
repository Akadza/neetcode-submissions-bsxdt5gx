class Solution {
    fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || t.isEmpty() || s.length < t.length) return ""
        
        var minStart = 0
        var minLen = Int.MAX_VALUE
        var left = 0
        var have = 0
        val required = t.length
        val need = IntArray(128)
        val window = IntArray(128)

        for (c in t) need[c.code]++

        for (right in s.indices) {
            val c = s[right].code
            window[c]++

            if (need[c] > 0 && window[c] <= need[c]) have++

            while (have == required && left <= right) {
                val currLen = right - left + 1
                if (currLen < minLen) {
                    minLen = currLen
                    minStart = left
                }
                val leftChar = s[left].code
                window[leftChar]--

                if (need[leftChar] > 0 && window[leftChar] < need[leftChar]) have--
                left++
            }
        }
        return if (minLen == Int.MAX_VALUE) "" else s.substring(minStart, minStart + minLen)
    }
}