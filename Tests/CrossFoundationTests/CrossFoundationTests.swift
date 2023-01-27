import XCTest
@testable import CrossFoundation

final class CrossFoundationTests: XCTestCase {

    /// Tests to ensure that `XCTest.XCTAssert*` statements are correctly translated into their `JUnit.assert*` equivalents.
    func testTesting() throws {
        XCTAssertTrue(true)
        XCTAssertFalse(false)
        XCTAssertNil(nil)
        XCTAssertNotNil("ABC")
        XCTAssertEqual(1, 1)
        XCTAssertNotEqual("X", "Y")
        XCTAssertIdentical(self, self)
        XCTAssertNotIdentical(self, CrossFoundationTests())

        // not supported by JUnit
        // XCTAssertGreaterThan(1, 0)
        // XCTAssertLessThan(0, 1)
        // XCTAssertLessThanOrEqual(1, 1)
        // XCTAssertGreaterThanOrEqual(1, 1)
    }

    func testRandom() {
        XCTAssertNotEqual(Random.shared.randomDouble(), Random.shared.randomDouble())
    }

    func testStringPadding() {
        assert("abc".pad(to: 5, with: "+") == "abc++")
    }
}

#if !GRYPHON
#if canImport(Skiff)
import Skiff

extension CrossFoundationTests {
    /// Transpiles to Kotlin as a side-effect of the test run; this will eventually be a package plug-in, but for now we run it as a side-effect of `swift test`.
    func testKotlinCrossFoundation() throws {
        try Skiff().transpileAndTest()
    }
}
#endif
#endif
