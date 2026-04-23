import java.lang.IndexOutOfBoundsException

val input = java.io.File("inputs/Day4.txt").readText()

val passports = input.split("\n\n")

val validFields = mapOf<String, (String) -> Boolean>(
        "byr" to { it.length == 4 && it.toInt() in 1920..2002 },
        "iyr" to { it.length == 4 && it.toInt() in 2010..2020 },
        "eyr" to { it.length == 4 && it.toInt() in 2020..2030 },
        "hgt" to fun(it: String): Boolean {
            val regex = """(\d+)(cm|in)""".toRegex()

            val (num, unit) = regex.find(it)?.destructured ?: return false
            return when (unit) {
                "cm" -> num.toInt() in 150..193
                "in" -> num.toInt() in 59..76
                else -> false
            }
        },
        "hcl" to { it.matches("""#[0-9a-f]{6}""".toRegex()) },
        "ecl" to { it in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") },
        "pid" to { it.matches("""[0-9]{9}""".toRegex()) }
)

var output = 0

for (passport in passports) {
    val fields = passport.split(' ', '\n')

    val pairs = fields.map {
        val pair = it.split(':')

        pair[0] to pair[1]
    }.toMap()

    val isValid = validFields.all { (key, validator) ->
        key in pairs.keys && validator(pairs[key] ?: "ಠ_ಠ")
    }
    if (isValid) output++
}

println(output) // 114