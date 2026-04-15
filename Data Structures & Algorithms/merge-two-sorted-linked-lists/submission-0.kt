/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current: ListNode? = dummy
        var ptr1 = list1
        var ptr2 = list2

        while(ptr1 != null && ptr2 != null) {
            if (ptr1.`val` <= ptr2.`val`) {
                current?.next = ptr1
                ptr1 = ptr1.next
            } else {
                current?.next = ptr2
                ptr2 = ptr2.next
            }
            current = current?.next
        }
        if (ptr1 != null) current?.next = ptr1
        else current?.next = ptr2

        return dummy.next
    }
}
