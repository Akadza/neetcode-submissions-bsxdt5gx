class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = position.zip(speed).sortedByDescending { it.first }
        val stack = ArrayDeque<Double>()

        for ((pos, spd) in cars) {
            val time = (target - pos).toDouble() / spd
            if (stack.isEmpty() || time > stack.first()) {
                stack.addFirst(time)
            }
        }
        return stack.size
    }
}