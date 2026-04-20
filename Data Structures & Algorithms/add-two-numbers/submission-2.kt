/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current: ListNode? = dummy
        var ptr1 = l1
        var ptr2 = l2
        var temp = 0

        while (ptr1 != null && ptr2 != null) {
            val sum = ptr1.`val` + ptr2.`val` + temp
            val node = ListNode(sum % 10)
            current?.next = node
            current = current?.next
            temp = sum / 10
            ptr1 = ptr1.next
            ptr2 = ptr2.next
        }

        while (ptr1 != null) {
            val sum = ptr1.`val` + temp
            val node = ListNode(sum % 10)
            current?.next = node
            current = current?.next
            ptr1 = ptr1.next
            temp = sum / 10
        }

        while (ptr2 != null) {
            val sum = ptr2.`val` + temp
            val node = ListNode(sum % 10)
            current?.next = node
            current = current?.next
            ptr2 = ptr2.next
            temp = sum / 10
        }

        if (temp != 0) {
            val node = ListNode(temp)
            current?.next = node
        }

        return dummy.next 
    }
}
