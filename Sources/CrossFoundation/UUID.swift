// MARK: UUID

#if SKIP

// gryphon insert: @JvmInline
public struct UUID : RawRepresentable {
    public let rawValue: java.util.UUID = java.util.UUID.randomUUID()

    public init(rawValue: java.util.UUID) {
        self.rawValue = rawValue
    }

    public static func `init`(uuidString: String) -> UUID {
        UUID(rawValue: java.util.UUID.fromString(uuidString))
    }

    public var uuidString: String {
        // java.util.UUID is lowercase, Foundation.UUID is uppercase
        return rawValue.toString().uppercase()
    }
}

#else

import struct Foundation.UUID

/// A byte buffer in memory.
public typealias UUID = Foundation.UUID

extension UUID {
}

#endif
