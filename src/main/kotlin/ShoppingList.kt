import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

data class Item(
    val name: String,
    val amount: Int,
    val price: BigDecimal
)

class ShoppingList {
    private val items = mutableListOf<Item>()
    private val date: LocalDate = LocalDate.now()

    fun addItem() {
        val name = readNonEmptyString("Enter the name of the item: ")
        val amount = readInt("Enter the amount you want to buy: ", min = 1)
        val price = readMoney("Enter the price of the product (e.g. 2.50): ")
        items.add(Item(name, amount, price))
        println("${CliColor.GREEN}Added: $amount x $name @ CHF ${price.toPlainString()}${CliColor.RESET}")
    }

    fun displayList() {
        println()
        println("${CliColor.CYAN}${CliColor.BOLD}--- Shopping List ($date) ---${CliColor.RESET}")

        if (items.isEmpty()) {
            println("${CliColor.YELLOW}No items yet.${CliColor.RESET}")
            return
        }

        var total = BigDecimal.ZERO

        items.forEachIndexed { index, item ->
            val lineTotal =
                item.price.multiply(BigDecimal(item.amount))
                    .setScale(2, RoundingMode.HALF_UP)

            total = total.add(lineTotal)

            println(
                "${CliColor.YELLOW}${index + 1}. ${item.amount}x ${item.name}${CliColor.RESET} " +
                        "- CHF ${item.price.toPlainString()} " +
                        "${CliColor.BLUE}(Line: CHF ${lineTotal.toPlainString()})${CliColor.RESET}"
            )
        }

        println("${CliColor.CYAN}----------------------------${CliColor.RESET}")
        println(
            "${CliColor.GREEN}${CliColor.BOLD}Total: CHF ${
                total.setScale(2, RoundingMode.HALF_UP).toPlainString()
            }${CliColor.RESET}"
        )
    }

    private fun readNonEmptyString(prompt: String): String {
        while (true) {
            print(prompt)
            val value = readln().trim()
            if (value.isNotEmpty()) return value
            println("${CliColor.RED}Please enter a non-empty text.${CliColor.RESET}")
        }
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

    private fun readMoney(prompt: String): BigDecimal {
        while (true) {
            print(prompt)
            val input = readln().trim().replace(",", ".")
            try {
                val value = BigDecimal(input)
                if (value < BigDecimal.ZERO) {
                    println("${CliColor.RED}Price cannot be negative.${CliColor.RESET}")
                    continue
                }
                return value.setScale(2, RoundingMode.HALF_UP)
            } catch (_: Exception) {
                println("${CliColor.RED}Please enter a valid price (e.g. 2.50).${CliColor.RESET}")
            }
        }
    }
}