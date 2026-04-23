val input  = java.io.File("inputs/Day2.txt").readLines()

var output = 0

for (pw in input) {
    val pattern = """^(\d+)-(\d+) ([a-z]): ([a-z]+)$""".toRegex()

    val (a, b, o, pass) = pattern.find(pw)?.destructured ?: throw Error(pw)

    if (pass.count { it == o[0] } in a.toInt()..b.toInt()) output++
}

println(output) // 456