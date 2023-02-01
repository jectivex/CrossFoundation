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
    ],
    targets: [
        .target(name: "CrossFoundation", dependencies: [],
        swiftSettings: [
            .unsafeFlags(["-emit-symbol-graph", "-include-spi-symbols", "-emit-symbol-graph-dir", ".build", "-symbol-graph-minimum-access-level", "internal"], .when(platforms: [.macOS, .linux], configuration: .debug)),
        ]),
        .testTarget(name: "CrossFoundationTests", dependencies: [
            "CrossFoundation",
        ]),
    ]
)

#if os(macOS) || os(Linux)
package.dependencies = [
    .package(url: "https://github.com/jectivex/Skiff", branch: "main"),
]
package.targets.last?.dependencies += [
    .product(name: "Skiff", package: "Skiff", condition: .when(platforms: [.macOS, .linux])),
]
#endif
