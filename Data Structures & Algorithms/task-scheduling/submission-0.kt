class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val counts = IntArray(26)
        for (task in tasks) counts[task - 'A']++

        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        for (count in counts) {
            if (count > 0) maxHeap.offer(count)
        }

        var time = 0

        while (maxHeap.isNotEmpty()) {
            val waitList = mutableListOf<Int>()
            val cycle = n + 1
            
            var taskCount = 0

            for (i in 0 until cycle) {
                if (maxHeap.isNotEmpty()) {
                    val current = maxHeap.poll()
                    if (current > 1) waitList.add(current - 1)
                    taskCount++
                }
            }
        

            for (remaining in waitList) {
                maxHeap.offer(remaining)
            }
            
            time += if (maxHeap.isEmpty()) taskCount else cycle
        }
    return time
    }
}
