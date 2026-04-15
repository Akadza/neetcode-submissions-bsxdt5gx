class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val buckets = Array(nums.size + 1) { mutableListOf<Int>() }

        for ((num, freq) in map) {
            buckets[freq].add(num)
        }

        val result = mutableListOf<Int>()

        for (i in buckets.size - 1 downTo 0) {
            for (num in buckets[i]) {
                result.add(num)
                if (result.size == k) {
                    return result.toIntArray()
                }
            }
        }

        return result.toIntArray()
    }
}