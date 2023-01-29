// =========================================
// GENERATED FILE; EDITS WILL BE OVERWRITTEN
// =========================================
package CrossFoundation
// MARK: Date
typealias TimeInterval = Double

// public typealias Date = java.util.Date
@JvmInline value class Date(
    val rawValue: java.util.Date = java.util.Date()
) {
    companion object {
        fun create(timeIntervalSince1970: TimeInterval): Date = Date(java.util.Date((timeIntervalSince1970 * 100).toLong()))
    }

    val timeIntervalSince1970: TimeInterval
        get() = rawValue.getTime() / 1000.0
}
