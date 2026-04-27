/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var cnt = 0
    private var res = 0

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        cnt = k
        dfs(root)
        return res
    }

    private fun dfs(node: TreeNode?) {
        if (node == null) {
            return
        }

        dfs(node.left)
        if (cnt == 0) return

        cnt--
        if (cnt == 0) {
            res = node.`val`
            return
        }

        dfs(node.right)
    }
}