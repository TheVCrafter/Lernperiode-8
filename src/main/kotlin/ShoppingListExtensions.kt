import java.math.BigDecimal
import java.math.RoundingMode

fun Item.lineTotal(): BigDecimal =
    price.multiply(BigDecimal(amount)).setScale(2, RoundingMode.HALF_UP)

fun List<Item>.totalCost(): BigDecimal {
    var total = BigDecimal.ZERO
    for (item in this) {
        total = total.add(item.lineTotal())
    }
    return total.setScale(2, RoundingMode.HALF_UP)
}