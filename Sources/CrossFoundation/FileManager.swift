// MARK: FileManager

#if SKIP
/// An interface to the file system compatible with ``Foundation.FileManager``
public final class FileManager {
    /// Returns the shared single file manager
    public static let `default` = FileManager()

    private init() {
    }

    public func removeItem(atPath path: String) throws {
        if java.io.File(path).delete() != true {
            throw UnableToDeleteFileError(path: path)
        }
    }

    public func removeItem(atPath url: URL) throws {
        if java.io.File(url.path).delete() != true {
            throw UnableToDeleteFileError(path: url.path)
        }
    }

    struct UnableToDeleteFileError : java.io.IOException {
        let path: String
    }
}


/// The system temporary folder
public func NSTemporaryDirectory() -> String {
    java.lang.System.getProperty("java.io.tmpdir")
}

/// The user's home directory.
public func NSHomeDirectory() -> String {
    java.lang.System.getProperty("user.home")
}

/// The current user name.
public func NSUserName() -> String {
    java.lang.System.getProperty("user.name")
}


#else
import class Foundation.FileManager

public typealias FileManager = Foundation.FileManager

public extension FileManager {

//    @available(*, deprecated, message: "file URLs not yet implemented on Kotlin side")
//    func removeItem(at url: URL) throws {
//        fatalError("unavailable in Kotlin")
//        //try self.removeItem(at: url)
//    }

}
#endif
