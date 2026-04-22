/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        invertRoot(root)
        return root
    }
    private fun invertRoot(root: TreeNode?): TreeNode? {
        if (root == null) return null
        invertRoot(root.left)
        invertRoot(root.right)
        val left = root.left
        root?.left = root?.right
        root?.right = left
        return root
    }
}
