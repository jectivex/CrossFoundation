import XCTest
#if canImport(CrossFoundationJVM)
@testable import CrossFoundationJVM
import Skiff
#else
@testable import CrossFoundation
#endif

final class CrossFoundationTests: XCTestCase {
    func testExample() throws {
        XCTAssertTrue(try CrossFoundation().importantFilesExist())
    }

//    #if canImport(Skiff)
//    public func testTranslateFramework() throws {
//        let projectBase = URL(fileURLWithPath: #file)
//            .deletingLastPathComponent()
//            .deletingLastPathComponent()
//            .deletingLastPathComponent()
//        let sourceBase = URL(fileURLWithPath: "Sources", isDirectory: true, relativeTo: projectBase)
//        let sourceURL = URL(fileURLWithPath: "CrossFoundation/CrossFoundation.swift", isDirectory: false, relativeTo: sourceBase)
//        let kotlinURL = URL(fileURLWithPath: "CrossFoundationKotlin/CrossFoundation.kt", isDirectory: false, relativeTo: sourceBase)
//
//        let skiff = try Skiff()
//
//        var source = try String(contentsOf: sourceURL)
//        var kotlin = try skiff.translate(swift: source, autoport: true)
//        kotlin = "package CrossFoundation\n\n" + kotlin
//        print("## Kotlin:\n", kotlin)
//        try kotlin.write(to: kotlinURL, atomically: true, encoding: .utf8)
//    }
//    #endif

}
