class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val candidate = mutableListOf<Int>()
        candidates.sort()

        fun backtrack(start: Int = 0, remaining: Int = target) {
            if (remaining == 0) {
                result.add(ArrayList(candidate))
                return
            }

            for (i in start until candidates.size) {
                if (i > start && candidates[i] == candidates[i - 1]) continue
                if (candidates[i] > remaining) break
                candidate.add(candidates[i])
                backtrack(i + 1, remaining - candidates[i])
                candidate.removeAt(candidate.size - 1)
            }
        }
        backtrack()
        return result
    }
}
