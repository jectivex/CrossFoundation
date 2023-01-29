package CrossFoundation

// MARK: Data
// public typealias Data = kotlin.ByteArray
data class Data(
    var rawValue: kotlin.ByteArray
) {
    companion object {
        fun `init`(filePath: String): Data = Data(java.io.File(filePath).readBytes())

        fun `init`(url: URL): Data {
            //        if url.isFileURL {
            //            return Data(java.io.File(url.path).readBytes())
            //        } else {
            // this seems to work for both file URLs and network URLs
            return Data(url.rawValue.openConnection().getInputStream().readBytes())

            //        }
        }
    }

    // TODO: RawRepresentable to generate `@JvmInline value class`
    val count: Int
        get() = rawValue.size
}
