package CrossFoundation

// MARK: Data
// public typealias Data = kotlin.ByteArray
data class Data(
    var rawValue: kotlin.ByteArray
) {
    companion object {
        fun `init`(filePath: String): Data = Data(java.io.File(filePath).readBytes())

        fun `init`(url: URL): Data = Data(java.io.File(url.path).readBytes())
    }

    // TODO: RawRepresentable to generate `@JvmInline value class`
    val count: Int
        get() = rawValue.size
}
