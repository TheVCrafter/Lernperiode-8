enum class Operator(val symbol: Char) {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    companion object {
        fun fromChar(c: Char): Operator? =
            values().firstOrNull { it.symbol == c }
    }
}