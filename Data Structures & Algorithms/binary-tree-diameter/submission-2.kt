/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0
        val leftHeight = maxHeight(root.left)
        val rightHeight = maxHeight(root.right)
        val diameter = leftHeight + rightHeight

        val sub = maxOf(
            diameterOfBinaryTree(root.left),
            diameterOfBinaryTree(root.right)
        )

        return maxOf(diameter, sub)

    }
    private fun maxHeight(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + maxOf(maxHeight(root.left), maxHeight(root.right))
    }
}
