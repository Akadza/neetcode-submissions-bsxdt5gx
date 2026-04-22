/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        return root?.apply {
            val leftNode = invertTree(left)
            val rightNode = invertTree(right)

            left = rightNode
            right = leftNode
        }
    }
}
