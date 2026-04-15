class MinStack() {

    private class Node(val value: Int, var next: Node? = null)

    private var head: Node? = null
    private var minHead: Node? = null  

    fun push(`val`: Int) {
        head = Node(`val`, head)

        if (minHead == null || `val` <= minHead!!.value) {
            minHead = Node(`val`, minHead)
        }
    }

    fun pop() {
        if (head == null) return

        val removed = head!!.value
        head = head!!.next

        if (minHead != null && removed == minHead!!.value) {
            minHead = minHead!!.next
        }

    }

    fun top(): Int {
        if (head == null) throw NoSuchElementException("Stack is empty")
        return head!!.value
    }

    fun getMin(): Int {
        if (minHead == null) throw NoSuchElementException("Stack is empty")
        return minHead!!.value
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */