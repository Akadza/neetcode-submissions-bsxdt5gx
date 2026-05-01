class Solution {

    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val candidate = mutableListOf<Int>()

        fun backtrack(start: Int) {
            result.add(ArrayList(candidate))

            for (i in start until nums.size) {
                candidate.add(nums[i])
                backtrack(i + 1)
                candidate.removeAt(candidate.size - 1)
            }
        }
        backtrack(0)
        return result
    }
}
