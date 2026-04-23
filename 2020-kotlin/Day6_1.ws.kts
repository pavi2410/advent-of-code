val input = java.io.File("inputs/Day6.txt").readText()

val groups = input.split("\n\n")

val output = groups.map {
    it.replace("\n", "").toSet().size
}.sum()

println(output) // 6947