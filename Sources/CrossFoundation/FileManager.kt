// =========================================
// GENERATED FILE; EDITS WILL BE OVERWRITTEN
// =========================================
package CrossFoundation
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

    open fun removeItem(url: URL) {
        if (java.io.File(url.path).delete() != true) {
            throw UnableToDeleteFileError(url.path)
        }
    }

    internal data class UnableToDeleteFileError(
        val path: String
    ): java.io.IOException()
}

fun NSTemporaryDirectory(): String = java.lang.System.getProperty("java.io.tmpdir")

fun NSHomeDirectory(): String = java.lang.System.getProperty("user.home")

fun NSUserName(): String = java.lang.System.getProperty("user.name")
