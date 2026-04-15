class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        return nums.size != nums.toSet().size
    }
}
