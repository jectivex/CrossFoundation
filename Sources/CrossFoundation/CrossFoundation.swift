import Foundation

// MARK: Random

/// A cross-platform random number generator
public class Random {
    /// The shared random singleton
    public static let shared = Random()

    private init() {
    }

    #if os(Android)
    //let random: java.util.Random = java.util.Random()
    let random: java.util.Random = java.security.SecureRandom()
    #else
    var rng: RandomNumberGenerator = SystemRandomNumberGenerator()
    #endif

    public func randomDouble() -> Double {
        #if os(Android)
        // Returns the next pseudorandom, uniformly distributed double value between 0.0 and 1.0 from this random number generator's sequence.
        // The general contract of nextDouble is that one double value, chosen (approximately) uniformly from the range 0.0d (inclusive) to 1.0d (exclusive), is pseudorandomly generated and returned.
        return random.nextDouble()
        #else
        return Double.random(in: 0..<1, using: &rng)
        #endif
    }
}

extension String {
    /// Sets the cell contents to the given span, either by truncating or padding it out.
    public func pad(to cellSpan: Int, with padding: String = " ", rightAlign: Bool = false) -> String {
        var cell = self
        while cell.count > cellSpan {
            cell = String(cell.dropLast())
        }
        while cell.count < cellSpan {
            if rightAlign {
                cell = padding + cell
            } else {
                cell = cell + padding
            }
        }
        return cell
    }
}

public extension Double {
    // Kotlin:  Unresolved reference: Range
//    public static func random(in range: Range<Double>) -> Double {
//        return Random().randomDouble()
//    }
}

// MARK: URL

#if os(Android)
public typealias URL = java.net.URL
#else
import struct Foundation.URL

public typealias URL = Foundation.URL

extension URL {
    /// Convenience init to match java.net.URL string constructor.
    public init!(_ stringURL: String) {
        self.init(string: stringURL)
    }
}
#endif

// MARK: Data

#if os(Android)
public typealias Data = kotlin.ByteArray

extension Data {
    /// Foundation uses `count`, Java uses `size`.
    public var count: Int { size }
}

/// Reads the data from the given file
public func readData(fromPath filePath: String) throws -> Data {
    java.io.File(filePath).readBytes()
}

#else
import struct Foundation.Data

public typealias Data = Foundation.Data

/// Reads the data from the given file
public func readData(fromPath filePath: String) throws -> Data {
    try Data(contentsOf: URL(fileURLWithPath: filePath, isDirectory: false))
}

#endif

// MARK: FileManager

#if os(Android)
/// An interface to the file system compatible with ``Foundation.FileManager``
public final class FileManager {
    public static let `default` = FileManager()

    private init() {
    }

    public func removeItem(atPath path: String) throws {
        if java.io.File(path).delete() != true {
            throw UnableToDeleteFileError(path: path)
        }
    }

    struct UnableToDeleteFileError : java.io.IOException {
        let path: String
    }
}
#else
import class Foundation.FileManager

public extension FileManager {
    @available(*, deprecated, message: "file URLs not yet implemented on Kotlin side")
    func removeItem(at url: URL) throws {
        fatalError("unavailable in Kotlin")
        //try self.removeItem(at: url)
    }

}
#endif


// MARK: Utilities

/// Output a debugging statement to the console.
public func dbg(_ value: String) {
    #if os(Android)
    System.out.println("DEBUG Kotlin: \(value)")
    #else
    print("DEBUG Swift: \(value)")
    #endif
}


// MARK: JSON

/// A JSON type, which can be null, boolean, number, string, array, or object.
public enum JSON {
    case nul
    case bol(boolean: Bool)
    case num(number: Double)
    case str(string: String)
    case arr(array: [JSON])
    case obj(dictionary: [String: JSON])
}




public class CrossFoundationTestHarness {
    public init() {
    }

    public static func crossFoundationTests() throws {
        dbg("running: crossFoundationTests")
        assert(1 == 1)
        assert(Random.shared.randomDouble() != Random.shared.randomDouble())
        assert("abc".pad(to: 5, with: "+") == "abc++")
    }

    public static func crossFoundationAsyncTests() async throws {
        dbg("running: crossFoundationAsyncTests")
        assert(2 == 2)
    }
}


