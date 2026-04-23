/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return checkHeight(root) != -1
    }
    private fun checkHeight(root: TreeNode?): Int {
        if (root == null) return 0
        
        val leftHeight = checkHeight(root.left)
        if (leftHeight == -1) return -1

        val rightHeight = checkHeight(root.right)
        if (rightHeight == -1) return -1

        if (abs(leftHeight - rightHeight) > 1) return -1
        return 1 + maxOf(leftHeight, rightHeight)
    }
}
