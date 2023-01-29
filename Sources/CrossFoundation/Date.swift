// MARK: Date

#if SKIP
public typealias TimeInterval = Double
// public typealias Date = java.util.Date

// gryphon insert: @JvmInline
public struct Date: RawRepresentable {
    public let rawValue: java.util.Date = java.util.Date()

    public init(rawValue: java.util.Date) {
        self.rawValue = rawValue
    }

    public static func create(_ timeIntervalSince1970: TimeInterval) -> Date {
        Date(java.util.Date((timeIntervalSince1970 * 100).toLong()))
    }

    public var timeIntervalSince1970: TimeInterval {
        rawValue.getTime() / 1000.0
    }
}

#else
import struct Foundation.Date
import struct Foundation.TimeInterval

/// A byte buffer in memory.
public typealias Date = Foundation.Date

extension Date {
    public static func create(_ timeIntervalSince1970: TimeInterval) -> Date {
        Date(timeIntervalSince1970: timeIntervalSince1970)
    }
}

#endif
