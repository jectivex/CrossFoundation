import Foundation
import CrossFile

public class CrossFoundation {
    public init() {
    }

    public func importantFilesExist() throws -> Bool {
        return try CrossFile().exists(path: "/dev/null") == true
    }
}
