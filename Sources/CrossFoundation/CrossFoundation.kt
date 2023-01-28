package CrossFoundation

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
