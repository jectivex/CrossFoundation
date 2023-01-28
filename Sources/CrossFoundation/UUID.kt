package CrossFoundation

// MARK: UUID
data class UUID(
    var rawValue: java.util.UUID = java.util.UUID.randomUUID()
) {
    // TODO: RawRepresentable to generate `@JvmInline value class`
    val uuidString: String
        get() {
            // java.util.UUID is lowercase, Foundation.UUID is uppercase
            return rawValue.toString().uppercase()
        }
}
