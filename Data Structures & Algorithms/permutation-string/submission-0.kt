class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val s1_freq = IntArray(26)
        val s2_freq = IntArray(26)

        for (i in s1.indices) {
            s1_freq[s1[i] - 'a']++
            s2_freq[s2[i] - 'a']++
        }
        if (s1_freq.contentEquals(s2_freq)) return true

        var left = 0
        for (right in s1.length until s2.length) {
            s2_freq[s2[right] - 'a']++
            s2_freq[s2[left] - 'a']--
            if (s1_freq.contentEquals(s2_freq)) return true
            left++
        }
        return false
    }
}