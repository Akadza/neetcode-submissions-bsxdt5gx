/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var ptr1 = head
        var length = (getLength(head) - 1) / 2
        for (i in 0..length - 1) {
            ptr1 = ptr1?.next
        }
        var head1 = head
        var head2 = reverseList(ptr1?.next)
        var ptr2 = head2
        while(ptr2 != null) {
            ptr2 = ptr2.next
        }
        ptr1?.next = null
        while (head1 != null) {
            val nextTemp1 = head1?.next
            val nextTemp2 = head2?.next
            head1?.next = head2
            head2?.next = nextTemp1
            head1 = nextTemp1
            head2 = nextTemp2
        }
    }
    private fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current = head

        while (current != null) {
            val nextTemp = current.next
            current.next = prev
            prev = current
            current = nextTemp
        }
        return prev
    }
    private fun getLength(head: ListNode?): Int {
        var ptr = head
        var len = 0
        while (ptr != null) {
            len++
            ptr = ptr.next
        }
        return len
    }
}
