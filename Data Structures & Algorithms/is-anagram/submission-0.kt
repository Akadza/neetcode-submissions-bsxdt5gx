class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val seen = IntArray(26)
        for (i in s.indices) {
            seen[s[i] - 'a']++
            seen[t[i] - 'a']--
        }
        for (c in seen) {
            if (c != 0) return false
        }
        return true
    }
}
