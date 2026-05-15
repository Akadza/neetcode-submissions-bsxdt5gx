class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size > n - 1) return false
        val preMap = Array(n) { mutableListOf<Int>() }

        for (edge in edges) {
            val (crs, pre) = edge
            preMap[crs].add(pre)
            preMap[pre].add(crs)
        }

        val visit = HashSet<Int>()

        fun dfs(node: Int, parent: Int): Boolean {
            if (node in visit) return false
            visit.add(node)
            for (nei in preMap[node]) {
                if (nei == parent) continue
                if (!dfs(nei, node)) return false
            }
            return true
        }
        return dfs(0, -1) && visit.size == n
    }
}
