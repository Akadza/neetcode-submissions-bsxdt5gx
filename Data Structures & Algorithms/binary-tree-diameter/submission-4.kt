/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var maxDiameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
       maxDiameter = 0
       calculateHeight(root)
       return maxDiameter
    }
    private fun calculateHeight(root: TreeNode?): Int {
        if (root == null) return 0
        val left = calculateHeight(root.left)
        val right = calculateHeight(root.right)

        maxDiameter = maxOf(left + right, maxDiameter)

        return 1 + maxOf(left, right)
    }
}
