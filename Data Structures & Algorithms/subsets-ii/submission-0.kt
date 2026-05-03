class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        
        fun backtrack(i: Int = 0, subset: MutableList<Int> = mutableListOf()) {
            result.add(ArrayList(subset))

            for (j in i until nums.size) {
                if (j != i && nums[j] == nums[j - 1]) continue

                subset.add(nums[j])
                backtrack(j + 1, subset)
                subset.removeAt(subset.size - 1)
            }
        }
        backtrack()
        return result
    }
}
