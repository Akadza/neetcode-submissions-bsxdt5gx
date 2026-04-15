class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size
        val stack = ArrayDeque<Int>()
        val result = IntArray(n)

        for (tempIdx in temperatures.indices) {
            val currTemp = temperatures[tempIdx]
            
            while (stack.isNotEmpty() && currTemp > temperatures[stack.last()]) {
                val prevIdx = stack.removeLast()
                result[prevIdx] = tempIdx - prevIdx
            }
            stack.addLast(tempIdx)
        }
        return result
    }
}
