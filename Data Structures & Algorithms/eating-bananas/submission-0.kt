class Solution {
fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.maxOrNull() ?: 1

        while (left < right) {
            val mid = left + (right - left) / 2 

            if (canEatInTime(piles, mid, h)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
    private fun canEatInTime(piles: IntArray, k: Int, h: Int): Boolean {
        var hours = 0L
        for (pile in piles) {
            hours += (pile + k - 1) / k
            if (hours > h) return false
        }
        return hours <= h
    }
}