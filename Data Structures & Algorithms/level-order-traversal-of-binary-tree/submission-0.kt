/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        if (root == null) return result

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val list = mutableListOf<Int>()
            val amount = queue.size

            for (i in 0 until amount) {
                val node = queue.removeFirst()
                list.add(node.`val`)
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }
            result.add(list)
        }
        return result
    }
}
