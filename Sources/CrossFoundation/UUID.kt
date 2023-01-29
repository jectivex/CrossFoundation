package CrossFoundation

// MARK: UUID
@JvmInline value class UUID(
    val rawValue: java.util.UUID = java.util.UUID.randomUUID()
) {
    val uuidString: String
        get() {
            // java.util.UUID is lowercase, Foundation.UUID is uppercase
            return rawValue.toString().uppercase()
        }
}
