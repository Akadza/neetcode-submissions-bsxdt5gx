class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        var count = 0
        val visiting = BooleanArray(n)
        val map = Array(n) { mutableListOf<Int>() }

        for ((parent, child) in edges) {
            map[parent].add(child)
            map[child].add(parent)
        }

        fun dfs(node: Int) {
            visiting[node] = true
            for (neighbor in map[node]) {
                if (!visiting[neighbor]) {
                    dfs(neighbor)
                }
            }
        }

        for (i in 0 until n) {
            if (!visiting[i]) {
                count++
                dfs(i)
            }
        }
        return count
    }
}
