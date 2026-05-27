class Solution {
    fun numDecodings(s: String): Int {
        var dp = 0
        var dp2 = 0
        var dp1 = 1
        for (i in s.length - 1 downTo 0) {
            if (s[i] == '0') dp = 0
            else dp = dp1
            if (i + 1 < s.length && (s[i] == '1' || (s[i] == '2' && s[i + 1]  <= '6')))  dp += dp2
            dp2 = dp1
            dp1 = dp
        }
        return dp1
    }
}
