// swift-tools-version: 5.7
import PackageDescription

let package = Package(
    name: "CrossFoundation",
    defaultLocalization: "en",
    platforms: [
        .macOS(.v12), .iOS(.v15), .tvOS(.v15), .watchOS(.v8)
    ],
    products: [
        .library(name: "CrossFoundation", targets: ["CrossFoundation"]),
    ],
    dependencies: [
        .package(url: "https://github.com/jectivex/Skiff", branch: "main"),
    ],
    targets: [
        .target(name: "CrossFoundation", dependencies: []),
        .testTarget(name: "CrossFoundationTests", dependencies: [
            "CrossFoundation",
            .product(name: "Skiff", package: "Skiff", condition: .when(platforms: [.macOS, .linux]))
        ]),
    ]
)
