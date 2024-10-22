fun calcTax(sum: Int = 1000): Double {
    val tax_ratio = 0.13

    return tax_ratio * sum.toDouble()
}

fun main() {
    val sum_user: String? = readLine()  //  или  val sum_user = readLine()!!.toInt()

    if (sum_user == null) return

    val sum: Int = sum_user.toInt()
    val tax: Double = calcTax(sum)

    println("For $sum tax is $tax")
}