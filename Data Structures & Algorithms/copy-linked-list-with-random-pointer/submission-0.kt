/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        val map = mutableMapOf<Node, Node>()

        var ptr = head
        while (ptr != null) {
            map[ptr] = Node(ptr.`val`)
            ptr = ptr.next
        }

        ptr = head

        while(ptr != null) {
            map[ptr]?.next = map[ptr.next]
            map[ptr]?.random = map[ptr.random]
            ptr = ptr.next
        }

        return map[head]
    }
}
