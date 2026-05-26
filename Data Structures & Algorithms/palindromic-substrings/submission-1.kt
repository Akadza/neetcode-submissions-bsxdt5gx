class Solution {
    fun countSubstrings(s: String): Int {
        val n = s.length
        val dp = Array(n) { BooleanArray(n) }
        var res = 0
        
        for (i in n - 1 downTo 0)  {
            for (j in i until n) {
                if (s[i] == s[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true
                    res++
                }
            }
        }

        return res
    }
}
