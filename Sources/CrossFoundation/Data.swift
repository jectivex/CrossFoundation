// MARK: Data

#if SKIP
// public typealias Data = kotlin.ByteArray

/// A byte buffer in memory.
///
/// This is a `Foundation.Data` wrapper around `kotlin.ByteArray`.
public struct Data { // TODO: RawRepresentable to generate `@JvmInline value class`
    public var rawValue: kotlin.ByteArray

    public init(rawValue: kotlin.ByteArray) {
        self.rawValue = rawValue
    }

    /// static init until constructor overload works
    public static func `init`(contentsOfFile filePath: String) throws -> Data {
        Data(java.io.File(filePath).readBytes())
    }

    /// static init until constructor overload works
    /// TODO: network URL
    public static func `init`(contentsOfURL url: URL) throws -> Data {
        Data(java.io.File(url.path).readBytes())
    }

    /// Foundation uses `count`, Java uses `size`.
    public var count: Int { rawValue.size }
}

#else
import struct Foundation.Data
import class Foundation.NSData

/// A byte buffer in memory.
public typealias Data = Foundation.Data

extension Data {
    public init(contentsOfFile filePath: String) throws {
        self = try NSData(contentsOfFile: filePath, options: []) as Data
    }
}


#endif
