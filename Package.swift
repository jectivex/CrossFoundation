// swift-tools-version: 5.7
import PackageDescription

let package = Package(
    name: "CrossFoundation",
    defaultLocalization: "en",
    platforms: [
        .macOS(.v12), .iOS(.v15), .tvOS(.v15), .watchOS(.v8)
    ],
    products: [
        .library(name: "CrossFoundation", type: .static, targets: ["CrossFoundation"]),
        .library(name: "CrossFoundationJVM", type: .dynamic, targets: ["CrossFoundationJVM"]),
    ],
    dependencies: [
        .package(url: "https://github.com/jectivex/CrossFile", branch: "main"),
        .package(url: "https://github.com/jectivex/Skiff", branch: "main"),
    ],
    targets: [
        .target(name: "CrossFoundation", dependencies: ["CrossFile"]),
        .testTarget(name: "CrossFoundationTests", dependencies: ["CrossFoundation"]),
        .target(name: "CrossFoundationJVM", dependencies: ["Skiff"]),
        .testTarget(name: "CrossFoundationJVMTests", dependencies: ["CrossFoundationJVM"]),
    ]
)
