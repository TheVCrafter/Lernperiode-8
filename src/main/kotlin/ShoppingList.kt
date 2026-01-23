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
        val name = ConsoleInput.readNonEmptyString("Enter the name of the item: ")
        val amount = ConsoleInput.readInt("Enter the amount you want to buy: ", min = 1)
        val price = readMoney("Enter the price of the product (e.g. 2.50): ")
        items.add(Item(name, amount, price))
        println("${CliColor.GREEN}Added: $amount x $name @ CHF ${price.toPlainString()}${CliColor.RESET}")
    }

    fun removeItem() {
        println()
        if (items.isEmpty()) {
            println("${CliColor.YELLOW}No items to remove.${CliColor.RESET}")
            return
        }

        displayList()

        val index1Based = ConsoleInput.readInt(
            prompt = "Enter the item number to remove (1-${items.size}): ",
            min = 1,
            max = items.size
        )

        val removed = items.removeAt(index1Based - 1)
        println("${CliColor.GREEN}Removed: ${removed.amount}x ${removed.name}${CliColor.RESET}")
    }

    fun searchItems() {
        println()
        if (items.isEmpty()) {
            println("${CliColor.YELLOW}No items yet.${CliColor.RESET}")
            return
        }

        val query = ConsoleInput.readNonEmptyString("Search by name: ")
        val matches = items.filter { it.name.contains(query, ignoreCase = true) }

        println("${CliColor.CYAN}${CliColor.BOLD}--- Search Results ---${CliColor.RESET}")
        if (matches.isEmpty()) {
            println("${CliColor.YELLOW}No matches for \"$query\".${CliColor.RESET}")
            return
        }

        matches.forEachIndexed { i, item ->
            println(
                "${CliColor.YELLOW}${i + 1}. ${item.amount}x ${item.name}${CliColor.RESET} " +
                        "- CHF ${item.price.toPlainString()} " +
                        "${CliColor.BLUE}(Line: CHF ${item.lineTotal().toPlainString()})${CliColor.RESET}"
            )
        }
    }

    fun displayList() {
        displayListInternal(items, titleSuffix = "")
    }

    fun displayListSortedByName() {
        val sorted = items.sortedBy { it.name.lowercase() }
        displayListInternal(sorted, titleSuffix = " (sorted by name)")
    }

    private fun displayListInternal(list: List<Item>, titleSuffix: String) {
        println()
        println("${CliColor.CYAN}${CliColor.BOLD}--- Shopping List ($date)$titleSuffix ---${CliColor.RESET}")

        if (list.isEmpty()) {
            println("${CliColor.YELLOW}No items yet.${CliColor.RESET}")
            return
        }

        list.forEachIndexed { index, item ->
            println(
                "${CliColor.YELLOW}${index + 1}. ${item.amount}x ${item.name}${CliColor.RESET} " +
                        "- CHF ${item.price.toPlainString()} " +
                        "${CliColor.BLUE}(Line: CHF ${item.lineTotal().toPlainString()})${CliColor.RESET}"
            )
        }

        println("${CliColor.CYAN}----------------------------${CliColor.RESET}")
        println("${CliColor.GREEN}${CliColor.BOLD}Total: CHF ${list.totalCost().toPlainString()}${CliColor.RESET}")
    }

    private fun readMoney(prompt: String): BigDecimal {
        while (true) {
            print(prompt)
            val input = readLine()?.trim().orEmpty().replace(",", ".")
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