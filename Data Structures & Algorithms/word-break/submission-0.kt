class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = wordDict.toSet()
        val memo = HashMap<Int, Boolean>()
        val maxLen = wordDict.maxOfOrNull { it.length } ?: 0

        fun dfs(i: Int): Boolean {
            memo[i]?.let { return it }
            if (i == s.length) return true

            for (j in i until minOf(s.length, i + maxLen)) {
                if (s.substring(i, j + 1) in wordSet) {
                    if (dfs(j + 1)) {
                        memo[i] = true
                        return true
                    }
                }
            }
            memo[i] = false
            return false
        }
        return dfs(0)
    }
}
