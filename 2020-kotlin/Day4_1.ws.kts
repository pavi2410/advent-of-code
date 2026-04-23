val input = java.io.File("inputs/Day4.txt").readText()

val passports = input.split("\n\n")

val validFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

var output = 0

for (passport in passports) {
    val fields = passport.split(' ', '\n')

    val keys = fields.map { it.split(':')[0] }

    if (validFields.all { it in keys }) output++
}

println(output) // 196