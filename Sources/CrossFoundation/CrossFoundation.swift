import Foundation

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



// MARK: Utilities

/// Output a debugging statement to the console.
public func dbg(_ value: String) {
    #if SKIP
    System.out.println("DEBUG Kotlin: \(value)")
    #else
    print("DEBUG Swift: \(value)")
    #endif
}


// MARK: JSON

/// A JSON type, which can be null, boolean, number, string, array, or object.
public enum JSON {
    case nul
    case bol(_ boolean: Bool)
    case num(_ number: Double)
    case str(_ string: String)
    case arr(_ array: [JSON])
    case obj(_ dictionary: [String: JSON])
}

