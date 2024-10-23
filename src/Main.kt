fun main() {
    val str: String? = readLine()
    var zeros_count = 0

    if (str == null) {return}

    for (i in str) {
        if (i == '0') zeros_count++
    }

    println("Колличество нулей: $zeros_count")
}