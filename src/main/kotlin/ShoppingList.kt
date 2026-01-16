import java.time.LocalDate
import java.math.BigDecimal
import java.math.RoundingMode

class ShoppingList {
    private val products = mutableListOf<String>()
    private val prices = mutableListOf<BigDecimal>()
    private val amounts = mutableListOf<Int>()
    private val date: LocalDate = LocalDate.now()

    fun addItem() {
        print("Enter the name of the item: ")
        val name = readln().trim()
        products.add(name)

        val amount = readInt("Enter the amount you want to buy: ", min = 1)
        amounts.add(amount)

        val price = readMoney("Enter the price of the product: ")
        prices.add(price)

        println("✅ Added: $amount x $name @ CHF ${price.toPlainString()}")
    }

    fun displayList() {
        println("\n--- Shopping List ($date) ---")

        if (products.isEmpty()) {
            println("No items yet.")
            return
        }

        var total = BigDecimal.ZERO

        for (i in products.indices) {
            val lineTotal = prices[i].multiply(BigDecimal(amounts[i]))
            total = total.add(lineTotal)

            println("${i + 1}. ${amounts[i]}x ${products[i]} - CHF ${prices[i]} (Line: CHF ${lineTotal.setScale(2, RoundingMode.HALF_UP)})")
        }

        println("----------------------------")
        println("Total: CHF ${total.setScale(2, RoundingMode.HALF_UP)}")
    }

    private fun readInt(prompt: String, min: Int? = null): Int {
        while (true) {
            print(prompt)
            val input = readln().trim()

            val value = input.toIntOrNull()
            if (value == null) {
                println("Please enter a valid whole number.")
                continue
            }

            if (min != null && value < min) {
                println("Please enter a number >= $min.")
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
                return BigDecimal(input).setScale(2, RoundingMode.HALF_UP)
            } catch (e: Exception) {
                println("Please enter a valid price (e.g. 2.50).")
            }
        }
    }
}