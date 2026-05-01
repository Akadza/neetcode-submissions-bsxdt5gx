class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val candidate = mutableListOf<Int>()

        fun backtrack(start: Int = 0, currentSum: Int = 0) {
            if (currentSum > target) return 
            if (currentSum == target) {
                result.add(ArrayList(candidate))
                return
            }
            for (i in start until nums.size) {
                candidate.add(nums[i])
                backtrack(i, currentSum + nums[i])
                candidate.removeAt(candidate.size - 1)
            }
        }
        backtrack()
        return result
    }
}
