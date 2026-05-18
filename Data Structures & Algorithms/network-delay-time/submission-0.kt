class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val adj = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        for (time in times) {
            val (u, v, t) = time
            adj[u].add(v to t)
        }

        val minTimes = IntArray(n + 1) { Int.MAX_VALUE }
        minTimes[k] = 0
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.add(k to 0)

        while (pq.isNotEmpty()) {
            val (currentU, currentTime) = pq.poll()
            
            if (currentTime > minTimes[currentU]) continue

            for ((neighborV, travelTime) in adj[currentU]) {
                val currentPath = minTimes[currentU] + travelTime
                if (currentPath < minTimes[neighborV]) {
                    minTimes[neighborV] = currentPath
                    pq.add(neighborV to currentPath)
                }
            }
        }
        var maxDelay = 0
        for (i in 1..n) {
            val time = minTimes[i]
            if (time == Int.MAX_VALUE) return -1
            maxDelay = maxOf(maxDelay, time)
        }

        return maxDelay
    }
}
