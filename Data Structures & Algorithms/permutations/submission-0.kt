class Solution {
    private val result = mutableListOf<List<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        backtrack(nums, 0)
        return result
    }

    private fun backtrack(nums: IntArray, idx: Int) {
        if(idx == nums.size) {
            result.add(nums.toList())
            return
        }
        for (i in idx until nums.size) {
            nums.swap(idx, i)
            backtrack(nums, idx + 1)
            nums.swap(idx, i)
        }
    }
    
    private fun IntArray.swap(i: Int, j: Int) {
        this[i] = this[j].also { this[j] = this[i] }
    }
}
