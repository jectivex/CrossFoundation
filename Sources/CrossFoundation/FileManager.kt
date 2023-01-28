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
    }

    internal data class UnableToDeleteFileError(
        val path: String
    ): java.io.IOException()
}
