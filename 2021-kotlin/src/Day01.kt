fun main() {
    fun part1(input: List<String>): Int {
        val depths = input.map { it.toInt() }
        val incs = depths.zipWithNext()
        return incs.count { (a, b) -> b > a }
    }

    fun part2(input: List<String>): Int {
        val depths = input.map { it.toInt() }
        val incs = depths.windowed(3).zipWithNext()
        return incs.count { (a, b) -> b.sum() > a.sum() }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input)) // 1624
    println(part2(input)) // 1653
}
