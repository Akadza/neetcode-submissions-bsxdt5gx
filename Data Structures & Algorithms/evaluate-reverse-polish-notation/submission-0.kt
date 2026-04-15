class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        val operators = "+-*/"

        for (i in tokens) {
            if (i in operators) {
                val secondDigit = stack.removeLast()
                val firstDigit = stack.removeLast()
                when(i) {
                    "+" -> stack.addLast(firstDigit + secondDigit)
                    "*" -> stack.addLast(firstDigit * secondDigit)
                    "/" -> stack.addLast(firstDigit / secondDigit)
                    "-" -> stack.addLast(firstDigit - secondDigit)
                }
            }
            else {
                stack.addLast(i.toInt())
            }
        }
        return stack.removeLast()
    }
}