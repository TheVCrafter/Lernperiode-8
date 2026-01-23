/**
 * TutorialPlayground.kt
 *
 * This file is ONLY for experimenting with tutorial concepts.
 * Code here does not need to be perfect or reused directly.
 */

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    println("=== Tutorial Playground ===")

    testEnums()
    testCalculatorLogic()
    testDataClassAndCopy()
    testLambdasAndCollections()
    testExtensionFunctions()
}

/* ---------------------------------------------------
   STEP 3 – Enums (Operator)
--------------------------------------------------- */
fun testEnums() {
    println("\n-- Enum test --")

    val op = Operator.fromChar('+')
    if (op != null) {
        println("Operator found: $op with symbol ${op.symbol}")
    } else {
        println("Invalid operator")
    }
}

/* ---------------------------------------------------
   STEP 4 – Calculator logic (no user input)
--------------------------------------------------- */
fun testCalculatorLogic() {
    println("\n-- Calculator logic test --")

    val calculator = Calculator()

    val a = 10
    val b = 5

    val resultAdd = calculator.calculate(a, b, Operator.ADD)
    val resultDiv = calculator.calculate(a, 0, Operator.DIVIDE)

    println("10 + 5 = $resultAdd")
    println("10 / 0 = $resultDiv (null means error)")
}

/* ---------------------------------------------------
   STEP 5 – Data class + copy()
--------------------------------------------------- */
fun testDataClassAndCopy() {
    println("\n-- Data class & copy test --")

    val original = Item(
        name = "Apple",
        amount = 2,
        price = BigDecimal("0.80")
    )

    val updated = original.copy(amount = 3)

    println("Original: $original")
    println("Updated : $updated")
}

/* ---------------------------------------------------
   STEP 6 & 7 – Lambdas, filter, sortedBy
--------------------------------------------------- */
fun testLambdasAndCollections() {
    println("\n-- Lambdas & collections test --")

    val items = listOf(
        Item("Milk", 1, BigDecimal("1.50")),
        Item("Bread", 2, BigDecimal("2.10")),
        Item("Apple", 5, BigDecimal("0.80"))
    )

    val filtered = items.filter { it.price < BigDecimal("2.00") }
    println("Items cheaper than CHF 2.00:")
    filtered.forEach { println(it) }

    val sorted = items.sortedBy { it.name.lowercase() }
    println("\nSorted by name:")
    sorted.forEach { println(it) }
}

/* ---------------------------------------------------
   STEP 6 – Extension functions
--------------------------------------------------- */
fun testExtensionFunctions() {
    println("\n-- Extension functions test --")

    val items = listOf(
        Item("Milk", 1, BigDecimal("1.50")),
        Item("Bread", 2, BigDecimal("2.10"))
    )

    items.forEach {
        println("${it.name} line total: CHF ${it.lineTotal()}")
    }

    println("Total cost: CHF ${items.totalCost()}")
}