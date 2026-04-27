/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return validNode(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
        
    private fun validNode(node: TreeNode?, left: Long, right: Long): Boolean {
        if (node == null) return true

        val value = node.`val`.toLong()
        if (value <= left || value >= right) return false
        return validNode(node.left, left, value) && validNode(node.right, value, right)
    }
}
