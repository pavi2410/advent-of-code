val input = java.io.File("inputs/Day8.txt").readLines()

fun run(instructions: List<String>): Pair<Boolean, Int> {
    var pc = 0
    var acc = 0

    val visitedLines = mutableListOf<Int>()

    while (pc < instructions.size) {
        if (pc in visitedLines) return false to acc
        visitedLines += pc

        val (opcode, arg) = instructions[pc].split(" ")

        when (opcode) {
            "acc" -> {
                acc += arg.toInt()
                pc++
            }
            "jmp" -> pc += arg.toInt()
            "nop" -> pc++
        }
    }
    return true to acc
}

fun flip(inst: String) = if (inst.startsWith("jmp")) inst.replace("jmp", "nop") else inst.replace("nop", "jmp")

var output = 0

for ((i, l) in input.withIndex()) {
    if (l.take(3) !in listOf("jmp", "nop")) continue

    val newInput = input.toMutableList().apply {
        this[i] = flip(this[i])
    }

    val (terminated, acc) = run(newInput)
    if (terminated) {
        output = acc
        break
    }
}

println(output) // 2212