class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        
        fun backtrack(
            openPar: Int = 1,
            closePar: Int = 0,
            candidate: String = "("
        ) {
            if (openPar + closePar == 2 * n) {
                result.add(candidate)
                return
            }
            if (openPar < n) {
                backtrack(openPar + 1, closePar, candidate + "(")
            }
            if (closePar < n && openPar > closePar) {
                backtrack(openPar, closePar + 1, candidate + ")")
            }
        }
        backtrack()
        return result
    }
}
