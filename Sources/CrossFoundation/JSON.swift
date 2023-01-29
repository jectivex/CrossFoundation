// MARK: JSON

// gryphon insert: import kotlinx.serialization.*
// gryphon insert: import kotlinx.serialization.json.Json

/// A JSON type, which can be null, boolean, number, string, array, or object.
// gryphon insert: @kotlinx.serialization.Serializable
public enum JSum : Equatable {
    // gryphon insert: @kotlinx.serialization.Serializable
    case nul
    // gryphon insert: @kotlinx.serialization.Serializable
    case bol(_ bol: Bool)
    // gryphon insert: @kotlinx.serialization.Serializable
    case num(_ num: Double)
    // gryphon insert: @kotlinx.serialization.Serializable
    case str(_ str: String)
    // gryphon insert: @kotlinx.serialization.Serializable
    case arr(_ arr: [JSum])
    // gryphon insert: @kotlinx.serialization.Serializable
    case obj(_ obj: [String: JSum])

    public static func == (lhs: JSum, rhs: JSum) -> Bool {
        // transpiler-friendly equality implementation
        switch lhs {
        case .nul:
            switch rhs {
            case .nul: return true
            default: return false
            }
        case let .bol(bol: b1):
            switch rhs {
            case let .bol(bol: b2): return b1 == b2
            default: return false
            }
        case let .num(num: n1):
            switch rhs {
            case let .num(num: n2): return n1 == n2
            default: return false
            }
        case let .str(str: s1):
            switch rhs {
            case let .str(str: s2): return s1 == s2
            default: return false
            }
        case let .arr(arr: a1):
            switch rhs {
            case let .arr(arr: a2): return a1 == a2
            default: return false
            }
        case let .obj(obj: o1):
            switch rhs {
            case let .obj(obj: o2): return o1 == o2
            default: return false
            }
        }
    }
}

/// A `JObj` is the associated dictionary type for a `JSum.obj`, which is equivalent to a JSON "object".
public typealias JObj = [String: JSum]


#if SKIP

// gryphon insert: inline fun <reified T: @Serializable Any> encodeJSON(value: T): String { return kotlinx.serialization.json.Json.encodeToString(value) }

#else

import Foundation

public func encodeJSON(_ value: Encodable) throws -> String {
    let encoder = JSONEncoder()
    encoder.outputFormatting = [.sortedKeys, .withoutEscapingSlashes]
    return try String(data: encoder.encode(value), encoding: .utf8) ?? "{}"
}


extension JSum {
    public func toJSON() throws -> String {
        try encodeJSON(self)
    }
}

extension JSum : ExpressibleByNilLiteral {
    /// Creates ``nul`` JSum
    @inlinable public init(nilLiteral: ()) {
        self = .nul
    }
}

extension JSum : ExpressibleByBooleanLiteral {
    /// Creates boolean JSum
    @inlinable public init(booleanLiteral value: BooleanLiteralType) {
        self = .bol(value)
    }
}

extension JSum : ExpressibleByFloatLiteral {
    /// Creates numeric JSum
    @inlinable public init(floatLiteral value: FloatLiteralType) {
        self = .num(value)
    }
}

extension JSum : ExpressibleByIntegerLiteral {
    /// Creates numeric JSum
    @inlinable public init(integerLiteral value: IntegerLiteralType) {
        self = .num(Double(value))
    }
}

extension JSum : ExpressibleByArrayLiteral {
    /// Creates an array of JSum
    @inlinable public init(arrayLiteral elements: JSum...) {
        self = .arr(elements)
    }
}

extension JSum : ExpressibleByStringLiteral {
    /// Creates String JSum
    @inlinable public init(stringLiteral value: String) {
        self = .str(value)
    }
}

extension JSum : ExpressibleByDictionaryLiteral {
    /// Creates a dictionary of `String` to `JSum`
    @inlinable public init(dictionaryLiteral elements: (String, JSum)...) {
        var d: Dictionary<String, JSum> = [:]
        for (k, v) in elements { d[k] = v }
        self = .obj(d)
    }
}

public extension JSum {
    /// JSum has a string subscript when it is an object type; setting a value on a non-obj type has no effect
    @inlinable subscript(key: String) -> JSum? {
        get {
            guard case .obj(let obj) = self else { return .none }
            return obj[key]
        }

        set {
            guard case .obj(var obj) = self else { return }
            obj[key] = newValue
            self = .obj(obj)
        }
    }

    /// JSum has a save indexed subscript when it is an array type; setting a value on a non-array type has no effect
    @inlinable subscript(index: Int) -> JSum? {
        get {
            guard case .arr(let arr) = self else { return .none }
            if index < 0 || index >= arr.count { return .none }
            return arr[index]
        }

        set {
            guard case .arr(var arr) = self else { return }
            if index < 0 || index >= arr.count { return }
            arr[index] = newValue ?? JSum.nul
            self = .arr(arr)
        }
    }
}

extension JSum : Encodable {
    @inlinable public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case .nul: try container.encodeNil()
        case .bol(let x): try container.encode(x)
        case .num(let x): try container.encode(x)
        case .str(let x): try container.encode(x)
        case .obj(let x): try container.encode(x)
        case .arr(let x): try container.encode(x)
        }
    }
}

extension JSum : Decodable {
    @inlinable public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        func decode<T: Decodable>() throws -> T { try container.decode(T.self) }
        if container.decodeNil() {
            self = .nul
        } else {
            do {
                self = try .bol(container.decode(Bool.self))
            } catch DecodingError.typeMismatch {
                do {
                    self = try .num(container.decode(Double.self))
                } catch DecodingError.typeMismatch {
                    do {
                        self = try .str(container.decode(String.self))
                    } catch DecodingError.typeMismatch {
                        do {
                            self = try .arr(decode())
                        } catch DecodingError.typeMismatch {
                            do {
                                self = try .obj(decode())
                            } catch DecodingError.typeMismatch {
                                throw DecodingError.typeMismatch(Self.self, DecodingError.Context(codingPath: decoder.codingPath, debugDescription: "Encoded payload not of an expected type"))
                            }
                        }
                    }
                }
            }
        }
    }
}

#endif

/// Convenience accessors for the payloads of the various `JSum` types
public extension JSum {
    // cannot use these because transpiler balks on same-named var

//    /// Returns the underlying String payload if this is a `JSum.str`, otherwise `.none`
//    @inlinable var str: String? {
//        guard case .str(let str) = self else { return .none }
//        return str
//    }
//
//    /// Returns the underlying Boolean payload if this is a `JSum.bol`, otherwise `.none`
//    @inlinable var bol: Bool? {
//        guard case .bol(let bol) = self else { return .none }
//        return bol
//    }
//
//    /// Returns the underlying Double payload if this is a `JSum.num`, otherwise `.none`
//    @inlinable var num: Double? {
//        guard case .num(let num) = self else { return .none }
//        return num
//    }
//
//    /// Returns the underlying JObj payload if this is a `JSum.obj`, otherwise `.none`
//    @inlinable var obj: JObj? {
//        guard case .obj(let obj) = self else { return .none }
//        return obj
//    }
//
//    /// Returns the underlying Array payload if this is a `JSum.arr`, otherwise `.none`
//    @inlinable var arr: [JSum]? {
//        guard case .arr(let arr) = self else { return .none }
//        return arr
//    }
//
//    /// Returns the underlying `nil` payload if this is a `JSum.nul`, otherwise `.none`
//    @inlinable var nul: Void? {
//        guard case .nul = self else { return .none }
//        return ()
//    }

    /// Returns the ``Bool`` value of type ``bol``.
    var bool: Bool? {
        switch self {
        case let .bol(bol: bol):
            return bol
        default:
            return nil
        }
    }

    /// Returns the ``Int`` value of type ``num``.
    var int: Int? {
        switch self {
        case let .num(num: num):
            if Double(Int(num)) == num {
                return Int(num)
            } else {
                return nil
            }
        default:
            return nil
        }
    }

    /// Returns the ``Double`` value of type ``num``.
    var double: Double? {
        switch self {
        case let .num(num: num):
            return num
        default:
            return nil
        }
    }

    /// Returns the ``String`` value of type ``str``.
    var string: String? {
        switch self {
        case let .str(str: str):
            return str
        default:
            return nil
        }
    }

    /// Returns the ``Array<JSum>`` value of type ``arr``.
    var array: [JSum]? {
        switch self {
        case let .arr(array: array):
            return array
        default:
            return nil
        }
    }

    /// Returns the ``dictionary<String, JSum>`` value of type ``obj``.
    var dictionary: [String: JSum]? {
        switch self {
        case let .obj(dictionary: dictionary):
            return dictionary
        default:
            return nil
        }
    }

    /// Returns the number of elements for an ``arr`` or key/values for an ``obj``
    var count: Int? {
        switch self {
        case let .arr(arr: arr):
            return arr.count
        case let .obj(obj: obj):
            return obj.count
        default:
            return nil
        }
    }
}
