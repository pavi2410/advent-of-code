fun main() {
    fun part1(input: List<String>): Int {
        var hp = 0
        var d = 0

        for (command in input) {
            val (op, x) = command.split(" ")
            val xi = x.toInt()
            when (op) {
                "forward" -> hp += xi
                "down" -> d += xi
                "up" -> d -= xi
            }
        }

        return hp * d
    }

    fun part2(input: List<String>): Int {
        var hp = 0
        var d = 0
        var aim = 0

        for (command in input) {
            val (op, x) = command.split(" ")
            val xi = x.toInt()
            when (op) {
                "forward" -> {
                    hp += xi
                    d += aim * xi
                }
                "down" -> aim += xi
                "up" -> aim -= xi
            }
        }

        return hp * d
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
