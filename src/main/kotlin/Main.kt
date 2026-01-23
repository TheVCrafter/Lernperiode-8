import kotlin.random.Random

fun main() {
    val shoppingList = ShoppingList()
    val calculator = Calculator()

    while (true) {
        println()
        println("${CliColor.CYAN}${CliColor.BOLD}===== Kotlin Programms =====${CliColor.RESET}")
        println("${CliColor.YELLOW}1) Add item to shopping list${CliColor.RESET}")
        println("${CliColor.YELLOW}2) Show shopping list${CliColor.RESET}")
        println("${CliColor.YELLOW}3) Remove item from shopping list${CliColor.RESET}")
        println("${CliColor.YELLOW}4) Show shopping list (sorted by name)${CliColor.RESET}")
        println("${CliColor.YELLOW}5) Search item in shopping list${CliColor.RESET}")
        println("${CliColor.YELLOW}6) Calculator${CliColor.RESET}")
        println("${CliColor.YELLOW}7) Random day (1-7)${CliColor.RESET}")
        println("${CliColor.YELLOW}8) Random sentence${CliColor.RESET}")
        println("${CliColor.YELLOW}9) Encrypt random CharArray${CliColor.RESET}")
        println("${CliColor.YELLOW}0) Exit${CliColor.RESET}")

        val key = ConsoleInput.readMenuKey(
            validKeys = setOf('0','1','2','3','4','5','6','7','8','9'),
            prompt = "${CliColor.CYAN}Choose an option [0-9]: ${CliColor.RESET}"
        )

        when (key) {
            '1' -> shoppingList.addItem()
            '2' -> shoppingList.displayList()
            '3' -> shoppingList.removeItem()
            '4' -> shoppingList.displayListSortedByName()
            '5' -> shoppingList.searchItems()
            '6' -> runCalculator(calculator)
            '7' -> runDayPicker()
            '8' -> runRandomSentence()
            '9' -> encryptRandomArray()
            '0' -> {
                println()
                println("${CliColor.GREEN}Goodbye!${CliColor.RESET}")
                return
            }
        }
    }
}

private fun runCalculator(calculator: Calculator) {
    val first = ConsoleInput.readInt("Enter the first number: ")
    val second = ConsoleInput.readInt("Enter the second number: ")
    val op = ConsoleInput.readOperator("Enter an operator (+, -, *, /): ")

    val result = calculator.calculate(first, second, op)
    if (result == null) {
        println("${CliColor.RED}Error: Division by zero is not allowed.${CliColor.RESET}")
        return
    }

    println("${CliColor.GREEN}Result: $result${CliColor.RESET}")
}

private fun runDayPicker() {
    val dayNumber = ConsoleInput.readInt("Enter a number between 1 and 7: ", min = 1, max = 7)
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