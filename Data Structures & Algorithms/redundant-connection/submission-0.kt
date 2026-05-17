class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = IntArray(edges.size + 1) { it }

        fun find(i: Int): Int {
            if (parent[i] == i) return i
            parent[i] = find(parent[i]) 
            return parent[i]
        }

        for (edge in edges) {
            val root1 = find(edge[0])
            val root2 = find(edge[1])

            if (root1 == root2) return edge
            parent[root1] = root2
        }

        return intArrayOf()
    }
}
