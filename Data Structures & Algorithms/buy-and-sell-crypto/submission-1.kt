class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var profit = 0
        for (p in prices) {
            if (p < min) {
                min = p
            } else {
                if (p - min > profit) profit = p - min
            }
        }
        return profit
    }
}