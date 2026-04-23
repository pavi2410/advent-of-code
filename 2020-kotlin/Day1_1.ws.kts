val input  = java.io.File("inputs/Day1.txt").readLines()

val numbers = input.map { it.toInt() }

var output = 0
outer@for (number1 in numbers) {
    for (number2 in numbers) {
        if (number1 + number2 == 2020) {
            output = number1 * number2
            break@outer
        }
    }
}

println(output) // 1005459