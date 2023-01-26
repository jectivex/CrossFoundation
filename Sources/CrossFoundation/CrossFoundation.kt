package CrossFoundation

// MARK: Random
open class Random {
    companion object {
        val shared: Random = Random()
    }

    private constructor() {
    }

    //let random: java.util.Random = java.util.Random()
    internal val random: java.util.Random = java.security.SecureRandom()

    open fun randomDouble(): Double {
        // Returns the next pseudorandom, uniformly distributed double value between 0.0 and 1.0 from this random number generator's sequence.
        // The general contract of nextDouble is that one double value, chosen (approximately) uniformly from the range 0.0d (inclusive) to 1.0d (exclusive), is pseudorandomly generated and returned.
        return random.nextDouble()
    }
}

fun String.pad(cellSpan: Int, padding: String = " ", rightAlign: Boolean = false): String {
    var cell: String = this

    while (cell.length > cellSpan) {
        cell = cell.dropLast(1)
    }

    while (cell.length < cellSpan) {
        if (rightAlign) {
            cell = padding + cell
        }
        else {
            cell = cell + padding
        }
    }

    return cell
}

// Kotlin:  Unresolved reference: Range
//    public static func random(in range: Range<Double>) -> Double {
//        return Random().randomDouble()
//    }
// MARK: URL
typealias URL = java.net.URL

// MARK: Data
typealias Data = kotlin.ByteArray

val Data.count: Int
    get() = size

fun readData(filePath: String): Data = java.io.File(filePath).readBytes()

// MARK: FileManager
class FileManager {
    companion object {
        val `default`: FileManager = FileManager()
    }

    private constructor() {
    }

    open fun removeItem(path: String) {
        if (java.io.File(path).delete() != true) {
            throw UnableToDeleteFileError(path)
        }
    }

    internal data class UnableToDeleteFileError(
        val path: String
    ): java.io.IOException()
}

// MARK: Utilities
fun dbg(value: String) {
    System.out.println("DEBUG Kotlin: ${value}")
}

// MARK: JSON
sealed class JSON {
    class Nul: JSON()
    class Bol(val boolean: Boolean): JSON()
    class Num(val number: Double): JSON()
    class Str(val string: String): JSON()
    class Arr(val array: List<JSON>): JSON()
    class Obj(val dictionary: Map<String, JSON>): JSON()
}

open class CrossFoundationTestHarness {
    companion object {
        fun crossFoundationTests() {
            dbg(value = "running: crossFoundationTests")
            assert(1 == 1)
            assert(Random.shared.randomDouble() != Random.shared.randomDouble())
            assert("abc".pad(cellSpan = 5, padding = "+") == "abc++")
        }

        fun crossFoundationAsyncTests() {
            dbg(value = "running: crossFoundationAsyncTests")
            assert(2 == 2)
        }
    }

    constructor() {
    }
}
