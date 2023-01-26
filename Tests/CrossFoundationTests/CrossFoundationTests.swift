import XCTest
@testable import CrossFoundation

final class CrossFoundationTests: XCTestCase {
    func testSwiftCrossFoundation() throws {
        try CrossFoundationTestHarness.crossFoundationTests()
    }

    func testSwiftCrossFoundationAsync() async throws {
        try await CrossFoundationTestHarness.crossFoundationAsyncTests()
    }

}

#if canImport(Skiff)
import Skiff

extension CrossFoundationTests {
    /// Transpiles to Kotlin as a side-effect of the test run
    func testKotlinCrossFoundation() throws {
        try Skiff().transpileAndTest()
    }
}
#endif
