package CrossFoundation

// MARK: Date
typealias TimeInterval = Double

// public typealias Date = java.util.Date
data class Date(
    var rawValue: java.util.Date = java.util.Date()
) {
    companion object {
        fun create(timeIntervalSince1970: TimeInterval): Date = Date(java.util.Date((timeIntervalSince1970 * 100).toLong()))
    }

    // TODO: RawRepresentable to generate `@JvmInline value class`
    val timeIntervalSince1970: TimeInterval
        get() = rawValue.getTime() / 1000.0
}
