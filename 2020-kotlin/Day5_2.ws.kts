val input = java.io.File("inputs/Day5.txt").readLines()

var output = input.map {
    it
            .replace('F', '0')
            .replace('B', '1')
            .replace('R', '1')
            .replace('L', '0')
}.map { it.toInt(2) }

println(output.sorted().run {
    (first()..last()).toSet() - this
}.first()) // 731