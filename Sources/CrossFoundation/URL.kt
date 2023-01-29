// =========================================
// GENERATED FILE; EDITS WILL BE OVERWRITTEN
// =========================================
package CrossFoundation
// MARK: URL
@JvmInline value class URL(
    val rawValue: java.net.URL
) {
    companion object {
        fun `init`(string: String): URL = URL(java.net.URL(string))

        fun `init`(string: String, relativeTo: URL): URL = URL(java.net.URL(relativeTo.rawValue, string))

        fun `init`(path: String, isDirectory: Boolean): URL {
            return URL(java.net.URL("file://" + path))
            // TODO: isDirectory handling?
        }
    }

    val absoluteString: String
        get() = rawValue.toExternalForm()
    val path: String
        get() = rawValue.path
    val host: String?
        get() = rawValue.host
    val lastPathComponent: String?
        get() = rawValue.path.split("/").last()
    val pathExtension: String?
        get() = lastPathComponent?.split(".")?.last()
    val isFileURL: Boolean
        get() = rawValue.`protocol` == "file"
}
