/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null) return true
        if (root == null) return false
        if (checkSubtree(root, subRoot)) return true
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }
    fun checkSubtree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true 
        if (p != null && q != null && p.`val` == q.`val`) {
            return checkSubtree(p.left, q.left) && checkSubtree(p.right, q.right)
        }
        return false
    }
}
