/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var preIdx = 0

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val indices = inorder.withIndex()
            .associate { (index, value) -> value to index }

        fun dfs(left: Int, right: Int): TreeNode? {
            if (left > right) {
                return null
            }

            val rootVal = preorder[preIdx++]
            val root = TreeNode(rootVal)
            val mid = indices[rootVal]!!

            root.left = dfs(left, mid - 1)
            root.right = dfs(mid + 1, right)

            return root
        }

        return dfs(0, inorder.lastIndex)
    }
}
