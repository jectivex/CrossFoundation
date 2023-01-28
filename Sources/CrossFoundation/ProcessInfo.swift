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

    public var hostName: String {
        java.net.InetAddress.getLocalHost().getHostName()
    }

//    public var hostType: HostType? {
//    }
}

#else

import class Foundation.ProcessInfo

public typealias ProcessInfo = Foundation.ProcessInfo

extension ProcessInfo {
}

#endif

public enum HostType : String {
    case android
    case iOS
    case linux
    case macOS
}
