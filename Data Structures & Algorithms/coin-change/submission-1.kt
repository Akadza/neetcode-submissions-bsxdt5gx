class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        val queue = ArrayDeque<Int>().apply { add(0) }
        val seen = BooleanArray(amount + 1) { false }
        seen[0] = true
        var res = 0
        while (queue.isNotEmpty()) {
            res++
            repeat(queue.size) {
                val cur = queue.removeFirst()
                for (coin in coins) {
                    val next = cur + coin
                    if (next == amount) return res
                    if (next > amount || seen[next]) continue
                    seen[next] = true
                    queue.addLast(next)
                }
            }
        }
        return -1
    }
}