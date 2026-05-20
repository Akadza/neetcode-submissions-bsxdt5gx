class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        if (n == 0) return 0
        if (n == 1) return cost[0]

        var a = cost[0]
        var b = cost[1]

        for (i in 2 until n) {
            val next = cost[i] + if (a < b) a else b
            a = b
            b = next
        }

        return if (a < b) a else b
    }
}