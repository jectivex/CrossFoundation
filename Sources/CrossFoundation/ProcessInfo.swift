// MARK: ProcessInfo

#if SKIP

/// An interface compatible with ``Foundation.ProcessInfo``
public final class ProcessInfo {
    public static let processInfo = ProcessInfo()

    private init() {
    }

    public var userName: String {
        java.lang.System.getProperty("user.name")
    }

    public var osName: String? {
        java.lang.System.getProperty("os.name")
    }

    public var hostName: String {
        java.net.InetAddress.getLocalHost().getHostName()
    }

    /// Whether we are currently running in a JVM
    public var isJavaRuntime: Bool {
        true
    }

//    public var hostType: HostType? {
//    }
}

#else

import class Foundation.ProcessInfo

public typealias ProcessInfo = Foundation.ProcessInfo

extension ProcessInfo {
    /// Whether we are currently running in a JVM
    public var isJavaRuntime: Bool {
        false
    }

    @available(*, deprecated, message: "unavailable on iOS")
    public var userName: String {
        fatalError("unavailable on iOS")
    }

    @available(*, deprecated, message: "unavailable on iOS")
    public var fullUserName: String {
        fatalError("unavailable on iOS")
    }

    public var osName: String? {
        nil
    }
}

#endif

public enum HostType : String {
    case android
    case iOS
    case linux
    case macOS
}
