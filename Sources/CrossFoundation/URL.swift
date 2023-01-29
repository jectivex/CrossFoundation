// MARK: URL

#if SKIP
// gryphon insert: @JvmInline
public struct URL : RawRepresentable {
    public let rawValue: java.net.URL

    public init(rawValue: java.net.URL) {
        self.rawValue = rawValue
    }

    public static func `init`(string: String) -> URL {
        URL(java.net.URL(string))
    }

    public static func `init`(string: String, relativeTo: URL) -> URL {
        URL(java.net.URL(relativeTo.rawValue, string))
    }

    public static func `init`(fileURLWithPath path: String, isDirectory: Bool) -> URL {
        return URL(java.net.URL("file://" + path)) // TODO: isDirectory handling?
    }

    public var absoluteString: String {
        rawValue.toExternalForm()
    }

    public var path: String {
        rawValue.path
    }

    public var host: String? {
        rawValue.host
    }

    public var lastPathComponent: String? {
        rawValue.path.split("/").last()
    }

    public var pathExtension: String? {
        lastPathComponent?.split(".")?.last()
    }

    public var isFileURL: Bool {
        rawValue.`protocol` == "file"
    }
}

#else
import struct Foundation.URL

public typealias URL = Foundation.URL

extension URL {
    @available(*, deprecated, message: "no kotlin equivalent")
    public var relativePath: String? {
        fatalError("no kotlin equivalent")
    }
}
#endif

