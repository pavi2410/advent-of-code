fun main() {
    fun part1(input: List<String>): Int {
        val m = input[0].length

        var gamma = ""
        var epsilon = ""

        for (i in 0 until m) {
            val bits = input.map { it[i] }.joinToString("")
            val zeroes = bits.count { it == '0' }
            val ones = bits.count { it == '1' }
            val mcb = if (zeroes > ones) '0' else '1'
            val lcb = if (zeroes > ones) '1' else '0'
            gamma += mcb
            epsilon += lcb
        }

        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>): Int {
        val m = input[0].length

        var inputO2 = input
        var inputCO2 = input

        for (i in 0 until m) {
            val bits = inputO2.map { it[i] }.joinToString("")
            val zeroes = bits.count { it == '0' }
            val ones = bits.count { it == '1' }
            val mcb = if (zeroes > ones) '0' else '1'
            inputO2 = inputO2.filter { it[i] == mcb }
            if (inputO2.size == 1) break
        }

        for (i in 0 until m) {
            val bits = inputCO2.map { it[i] }.joinToString("")
            val zeroes = bits.count { it == '0' }
            val ones = bits.count { it == '1' }
            val lcb = if (zeroes > ones) '1' else '0'
            inputCO2 = inputCO2.filter { it[i] == lcb }
            if (inputCO2.size == 1) break
        }

        return inputO2[0].toInt(2) * inputCO2[0].toInt(2)
    }

    val testInput = readInput("Day03_test")
    verify("-", 198, part1(testInput))
    verify("-", 230, part2(testInput))

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
