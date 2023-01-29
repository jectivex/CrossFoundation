// =========================================
// GENERATED FILE; EDITS WILL BE OVERWRITTEN
// =========================================
package CrossFoundation
// MARK: ProcessInfo
class ProcessInfo {
    companion object {
        val processInfo: ProcessInfo = ProcessInfo()
    }

    private constructor() {
    }

    open val userName: String
        get() = java.lang.System.getProperty("user.name")
    open val osName: String?
        get() = java.lang.System.getProperty("os.name")
    open val hostName: String
        get() = java.net.InetAddress.getLocalHost().getHostName()
    open val isJavaRuntime: Boolean
        get() = true

    //    public var hostType: HostType? {
    //    }
}

enum class HostType(val rawValue: String) {
    ANDROID(rawValue = "android"),
    I_OS(rawValue = "iOS"),
    LINUX(rawValue = "linux"),
    MAC_OS(rawValue = "macOS");

    companion object {
        operator fun invoke(rawValue: String): HostType? = values().firstOrNull { it.rawValue == rawValue }
    }
}
