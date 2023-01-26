import Foundation

public class CrossFoundationTestHarness {
    public init() {
    }

    public static func crossFoundationTests() throws {
        assert(1 == 1)
    }

    public static func crossFoundationAsyncTests() async throws {
        assert(2 == 2)
    }
}


