class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var prev2 = cost[0]
        var prev1 = cost[1]
        for (i in 2 until cost.size) prev2 = prev1.also { prev1 = cost[i] + minOf(prev1, prev2) }
        return minOf(prev1, prev2)
    }  
}