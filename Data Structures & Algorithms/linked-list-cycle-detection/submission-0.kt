/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var ptr1: ListNode? = head
        var ptr2: ListNode? = head
        while (ptr2 != null) {
            ptr2 = ptr2.next ?: return false
            ptr2 = ptr2?.next
            ptr1 = ptr1?.next
            if (ptr1 == ptr2) return true
        }
        return false
    }
}
