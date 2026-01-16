import kotlin.random.Random

fun main() {
    val shoppingList = ShoppingList()

    while (true) {
        println()
        println("${CliColor.CYAN}${CliColor.BOLD}===== Kotlin Programms =====${CliColor.RESET}")
        println("${CliColor.YELLOW}1) Add item to shopping list${CliColor.RESET}")
        println("${CliColor.YELLOW}2) Show shopping list${CliColor.RESET}")
        println("${CliColor.YELLOW}3) Calculator${CliColor.RESET}")
        println("${CliColor.YELLOW}4) Random day (1-7)${CliColor.RESET}")
        println("${CliColor.YELLOW}5) Random sentence${CliColor.RESET}")
        println("${CliColor.YELLOW}6) Encrypt random CharArray${CliColor.RESET}")
        println("${CliColor.YELLOW}0) Exit${CliColor.RESET}")
        print("${CliColor.CYAN}Choose an option [0-6]: ${CliColor.RESET}")

        when (readMenuKey(setOf('0', '1', '2', '3', '4', '5', '6'))) {
            '1' -> shoppingList.addItem()
            '2' -> shoppingList.displayList()
            '3' -> runCalculator()
            '4' -> runDayPicker()
            '5' -> runRandomSentence()
            '6' -> encryptRandomArray()
            '0' -> {
                println()
                println("${CliColor.GREEN}Goodbye!${CliColor.RESET}")
                return
            }
        }
    }
}

private fun readMenuKey(validKeys: Set<Char>): Char {
    while (true) {
        val key = System.`in`.read().toChar()
        if (key == '\n' || key == '\r') continue
        if (key in validKeys) {
            println(key)
            return key
        }
        println()
        println("${CliColor.RED}Invalid key. Use: ${validKeys.joinToString(", ")}${CliColor.RESET}")
        print("${CliColor.CYAN}Choose an option: ${CliColor.RESET}")
    }
}

private fun runCalculator() {
    val first = readInt("Enter the first number: ")
    val second = readInt("Enter the second number: ")
    val op = readOperator("Enter an operator (+, -, *, /): ")
    val calculator = Calculator(first, second, op)
    println("${CliColor.GREEN}Result: ${calculator.Calculate()}${CliColor.RESET}")
}

private fun runDayPicker() {
    val dayNumber = readInt("Enter a number between 1 and 7: ", min = 1, max = 7)
    val day = when (dayNumber) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        5 -> "Friday"
        6 -> "Saturday"
        7 -> "Sunday"
        else -> ""
    }
    println("${CliColor.GREEN}Day: $day${CliColor.RESET}")
}

private fun runRandomSentence() {
    val sentences = createMap()
    println("${CliColor.GREEN}${giveRandomSentence(sentences)}${CliColor.RESET}")
}

fun createMap(): Map<Int, String> =
    mapOf(
        0 to "I like Coffee!",
        1 to "This is Kotlin!",
        2 to "I coded this!"
    )

fun giveRandomSentence(sentenceMap: Map<Int, String>): String {
    val randomInt = Random.nextInt(0, sentenceMap.size)
    return sentenceMap.getValue(randomInt)
}

fun encryptRandomArray() {
    val chars = ('a'..'z') + ('A'..'Z')
    val randomChars = CharArray(10) { chars.random() }
    println("${CliColor.BLUE}Original:  ${randomChars.concatToString()}${CliColor.RESET}")
    val shift = 5
    val encrypted = CharArray(randomChars.size) { i ->
        (randomChars[i].code + shift).toChar()
    }
    println("${CliColor.PURPLE}Encrypted: ${encrypted.concatToString()}${CliColor.RESET}")
}

private fun readInt(prompt: String, min: Int? = null, max: Int? = null): Int {
    while (true) {
        print(prompt)
        val value = readln().trim().toIntOrNull()
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

private fun readOperator(prompt: String): Char {
    while (true) {
        print(prompt)
        val input = readln().trim()
        if (input.length == 1 && input[0] in charArrayOf('+', '-', '*', '/')) {
            return input[0]
        }
        println("${CliColor.RED}Invalid operator. Use one of: + - * /${CliColor.RESET}")
    }
}