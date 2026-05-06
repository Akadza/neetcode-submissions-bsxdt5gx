class Solution {
    fun partition(s: String): List<List<String>> {
        val res = mutableListOf<List<String>>()
        val part = mutableListOf<String>()

        fun dfs(i: Int) {
            if (i >= s.length) {
                res.add(part.toList())
                return
            }
            for (j in i until s.length) {
                if (isPali(s, i, j)) {
                    part.add(s.substring(i, j + 1))
                    dfs(j + 1)
                    part.removeAt(part.size - 1)
                }
            }
        }
        dfs(0)
        return res
    }

    private fun isPali(s: String, l: Int, r: Int): Boolean {
        var left = l
        var right = r

        while (left < right) {
            if (s[right] != s[left]) return false
            right--
            left++
        }
        return true
    }
}
