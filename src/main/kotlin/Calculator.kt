class Calculator {
    fun calculate(a: Int, b: Int, op: Operator): Int? {
        return when (op) {
            Operator.ADD -> a + b
            Operator.SUBTRACT -> a - b
            Operator.MULTIPLY -> a * b
            Operator.DIVIDE -> if (b != 0) a / b else null
        }
    }
}