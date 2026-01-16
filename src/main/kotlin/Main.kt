import kotlin.random.Random

fun main() {
    val shoppingList = ShoppingList()

    while (true) {
        println()
        println("===== Kotlin CLI =====")
        println("1) Add item to shopping list")
        println("2) Show shopping list")
        println("3) Calculator")
        println("4) Random day (1-7)")
        println("5) Random sentence")
        println("6) Encrypt random CharArray")
        println("0) Exit")
        print("Choose an option: ")

        when (readIntOrNull()) {
            1 -> shoppingList.addItem()
            2 -> shoppingList.displayList()
            3 -> runCalculator()
            4 -> runDayPicker()
            5 -> runRandomSentence()
            6 -> encryptRandomArray()
            0 -> {
                println("Goodbye!")
                return
            }
            else -> println("Invalid option. Try again.")
        }
    }
}

private fun runCalculator() {
    val first = readInt("Enter the first number: ")
    val second = readInt("Enter the second number: ")
    val op = readOperator("Enter an operator (+, -, *, /): ")

    val calculator = Calculator(first, second, op)
    println("Result: ${calculator.Calculate()}")
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
        else -> "Invalid"
    }

    println("Day: $day")
}

private fun runRandomSentence() {
    val sentences = createMap()
    println(giveRandomSentence(sentences))
}

fun createMap(): Map<Int, String> {
    return mapOf(
        0 to "I like Coffee!",
        1 to "This is Kotlin!",
        2 to "I coded this!"
    )
}

fun giveRandomSentence(sentenceMap: Map<Int, String>): String {
    val randomInt = Random.nextInt(0, sentenceMap.size)
    return sentenceMap.getValue(randomInt)
}

fun encryptRandomArray() {
    val chars = ('a'..'z') + ('A'..'Z')
    val randomChars = CharArray(10) { chars.random() }

    println("Original:  ${randomChars.concatToString()}")

    val shift = 5
    val encrypted = CharArray(randomChars.size) { i ->
        (randomChars[i].code + shift).toChar()
    }

    println("Encrypted: ${encrypted.concatToString()}")
}

private fun readInt(prompt: String, min: Int? = null, max: Int? = null): Int {
    while (true) {
        print(prompt)
        val value = readIntOrNull()
        if (value == null) {
            println("Please enter a valid whole number.")
            continue
        }
        if (min != null && value < min) {
            println("Please enter a number >= $min.")
            continue
        }
        if (max != null && value > max) {
            println("Please enter a number <= $max.")
            continue
        }
        return value
    }
}

private fun readIntOrNull(): Int? = readln().trim().toIntOrNull()

private fun readOperator(prompt: String): Char {
    while (true) {
        print(prompt)
        val input = readln().trim()
        if (input.length == 1 && input[0] in charArrayOf('+', '-', '*', '/')) {
            return input[0]
        }
        println("Invalid operator. Use one of: + - * /")
    }
}