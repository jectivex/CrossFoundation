// =========================================
// GENERATED FILE; EDITS WILL BE OVERWRITTEN
// =========================================
package CrossFoundation
// MARK: UUID
@JvmInline value class UUID(
    val rawValue: java.util.UUID = java.util.UUID.randomUUID()
) {
    companion object {
        fun `init`(uuidString: String): UUID = UUID(java.util.UUID.fromString(uuidString))
    }

    val uuidString: String
        get() {
            // java.util.UUID is lowercase, Foundation.UUID is uppercase
            return rawValue.toString().uppercase()
        }
}
