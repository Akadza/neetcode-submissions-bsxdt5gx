class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        for (stone in stones) maxHeap.offer(stone)

        while (maxHeap.size > 1) {
            val o1 = maxHeap.poll()
            val o2 = maxHeap.poll()
            if (o1 != o2) maxHeap.offer(o1 - o2)
        }
        return if (maxHeap.isEmpty) 0 else maxHeap.peek()
    }
}
