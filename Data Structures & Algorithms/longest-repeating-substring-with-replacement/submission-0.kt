class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var maxFreq = 0
        var left = 0
        val freq = IntArray(26)
        var result = 0

        for (right in s.indices) {
            val idx = s[right] - 'A'
            freq[idx]++

            maxFreq = maxOf(maxFreq, freq[idx])
            while ((right - left + 1) - maxFreq > k) {
                freq[s[left] - 'A']--
                left++
            }
            result = maxOf(maxFreq, right - left + 1)
        }
        return result
    }
}
