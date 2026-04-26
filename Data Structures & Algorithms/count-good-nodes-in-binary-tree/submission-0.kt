/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        var count = 0

        fun dfs(node: TreeNode?, max: Int) {
            if (node == null) return
            if (node.`val` >= max) count++
            val nextMax = maxOf(node.`val`, max) 
            dfs(node.left, nextMax)
            dfs(node.right, nextMax)
        }
        dfs(root, root?.`val` ?: Int.MIN_VALUE)
        return count
    }
}