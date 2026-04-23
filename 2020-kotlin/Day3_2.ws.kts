val input = java.io.File("inputs/Day3.txt").readLines()

fun countTrees(step: Pair<Int, Int>): Int {
    val height = input.size
    val width = input[0].length
    var x = 0
    var y = 0
    var treesCount = 0

    while (y < height) {
        if (input[y][x % width] == '#')
            treesCount++

        x += step.first
        y += step.second
    }

    return treesCount
}

var output = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
        .map { countTrees(it) }
        .fold(1L) { product, trees -> product * trees }

println(output) // 3154761400