object ConsoleInput {

    fun readNonEmptyString(prompt: String): String {
        while (true) {
            print(prompt)
            val value = readLine()?.trim().orEmpty()
            if (value.isNotEmpty()) return value
            println("${CliColor.RED}Please enter a non-empty text.${CliColor.RESET}")
        }
    }

    fun readInt(prompt: String, min: Int? = null, max: Int? = null): Int {
        while (true) {
            print(prompt)
            val value = readLine()?.trim()?.toIntOrNull()
            if (value == null) {
                println("${CliColor.RED}Please enter a valid whole number.${CliColor.RESET}")
                continue
            }
            if (min != null && value < min) {
                println("${CliColor.RED}Please enter a number >= $min.${CliColor.RESET}")
                continue
            }
            if (max != null && value > max) {
                println("${CliColor.RED}Please enter a number <= $max.${CliColor.RESET}")
                continue
            }
            return value
        }
    }

    fun readMenuKey(validKeys: Set<Char>, prompt: String): Char {
        while (true) {
            print(prompt)
            val input = readLine()?.trim().orEmpty()
            val key = input.firstOrNull()
            if (key != null && key in validKeys) return key

            println("${CliColor.RED}Invalid key. Use: ${validKeys.joinToString(", ")}${CliColor.RESET}")
        }
    }

    fun readOperator(prompt: String): Operator {
        while (true) {
            print(prompt)
            val input = readLine()?.trim().orEmpty()
            val c = input.firstOrNull()
            val op = c?.let { Operator.fromChar(it) }
            if (op != null) return op

            println("${CliColor.RED}Invalid operator. Use one of: + - * /${CliColor.RESET}")
        }
    }
}