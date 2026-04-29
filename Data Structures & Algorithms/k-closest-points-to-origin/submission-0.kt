class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<IntArray>(compareByDescending { it[0] * it[0] + it[1] * it[1] })
        
        for (point in points) {
            maxHeap.offer(point)
            if (maxHeap.size > k) maxHeap.poll()
        }

        return Array(k) { maxHeap.poll() }
    }
}
