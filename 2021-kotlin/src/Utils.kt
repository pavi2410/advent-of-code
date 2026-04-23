import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

const val RED = "\u001B[31m"
const val GREEN = "\u001B[32m"
const val BLUE = "\u001B[34m"
const val RESET = "\u001B[0m"
fun <T> verify(input: String, expected: T, actual: T) {
    fun red(s: T) = RED + s + RESET
    fun green(s: T) = GREEN + s + RESET
    fun blue(s: String) = BLUE + s + RESET
    if (expected != actual) {
        println("""Failed for: ${blue(input)}; expected: ${green(expected)}; actual: ${red(actual)}""")
    }
}