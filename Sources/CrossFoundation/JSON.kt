// =========================================
// GENERATED FILE; EDITS WILL BE OVERWRITTEN
// =========================================
package CrossFoundation
// MARK: JSON
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
@kotlinx.serialization.Serializable

sealed class JSum {
    class nul: JSum()
    class bol(val bol: Boolean): JSum()
    class num(val num: Double): JSum()
    class str(val str: String): JSum()
    class arr(val arr: List<JSum>): JSum()
    class obj(val obj: Map<String, JSum>): JSum()

    override open fun equals(other: Any?): Boolean {
        val lhs: JSum = this
        val rhs: Any? = other
        if (rhs is JSum) {
            // transpiler-friendly equality implementation
            when (lhs) {
                is JSum.nul -> return when (rhs) {
    is JSum.nul -> true
    else -> false
}
                is JSum.bol -> {
                    val b1: Boolean = lhs.bol
                    return when (rhs) {
                        is JSum.bol -> {
                            val b2: Boolean = rhs.bol
                            b1 == b2
                        }
                        else -> false
                    }
                }
                is JSum.num -> {
                    val n1: Double = lhs.num
                    return when (rhs) {
                        is JSum.num -> {
                            val n2: Double = rhs.num
                            n1 == n2
                        }
                        else -> false
                    }
                }
                is JSum.str -> {
                    val s1: String = lhs.str
                    return when (rhs) {
                        is JSum.str -> {
                            val s2: String = rhs.str
                            s1 == s2
                        }
                        else -> false
                    }
                }
                is JSum.arr -> {
                    val a1: List<JSum> = lhs.arr
                    return when (rhs) {
                        is JSum.arr -> {
                            val a2: List<JSum> = rhs.arr
                            a1 == a2
                        }
                        else -> false
                    }
                }
                is JSum.obj -> {
                    val o1: Map<String, JSum> = lhs.obj
                    return when (rhs) {
                        is JSum.obj -> {
                            val o2: Map<String, JSum> = rhs.obj
                            o1 == o2
                        }
                        else -> false
                    }
                }
            }
        }
        else {
            return false
        }
    }
}

typealias JObj = Map<String, JSum>

inline fun <reified T: @Serializable Any> encodeJSON(value: T): String { return kotlinx.serialization.json.Json.encodeToString(value) }

// cannot use these because transpiler balks on same-named var
//    /// Returns the underlying String payload if this is a `JSum.str`, otherwise `.none`
//    @inlinable var str: String? {
//        guard case .str(let str) = self else { return .none }
//        return str
//    }
//
//    /// Returns the underlying Boolean payload if this is a `JSum.bol`, otherwise `.none`
//    @inlinable var bol: Bool? {
//        guard case .bol(let bol) = self else { return .none }
//        return bol
//    }
//
//    /// Returns the underlying Double payload if this is a `JSum.num`, otherwise `.none`
//    @inlinable var num: Double? {
//        guard case .num(let num) = self else { return .none }
//        return num
//    }
//
//    /// Returns the underlying JObj payload if this is a `JSum.obj`, otherwise `.none`
//    @inlinable var obj: JObj? {
//        guard case .obj(let obj) = self else { return .none }
//        return obj
//    }
//
//    /// Returns the underlying Array payload if this is a `JSum.arr`, otherwise `.none`
//    @inlinable var arr: [JSum]? {
//        guard case .arr(let arr) = self else { return .none }
//        return arr
//    }
//
//    /// Returns the underlying `nil` payload if this is a `JSum.nul`, otherwise `.none`
//    @inlinable var nul: Void? {
//        guard case .nul = self else { return .none }
//        return ()
//    }
internal val JSum.bool: Boolean?
    get() {
        return when (this) {
            is JSum.bol -> {
                val bol: Boolean = this.bol
                bol
            }
            else -> null
        }
    }
internal val JSum.int: Int?
    get() {
        when (this) {
            is JSum.num -> {
                val num: Double = this.num
                if (num.toInt().toDouble() == num) {
                    return num.toInt()
                }
                else {
                    return null
                }
            }
            else -> return null
        }
    }
internal val JSum.double: Double?
    get() {
        return when (this) {
            is JSum.num -> {
                val num: Double = this.num
                num
            }
            else -> null
        }
    }
internal val JSum.string: String?
    get() {
        return when (this) {
            is JSum.str -> {
                val str: String = this.str
                str
            }
            else -> null
        }
    }
internal val JSum.array: List<JSum>?
    get() {
        return when (this) {
            is JSum.arr -> {
                val array = this.array
                array
            }
            else -> null
        }
    }
internal val JSum.dictionary: Map<String, JSum>?
    get() {
        return when (this) {
            is JSum.obj -> {
                val dictionary = this.dictionary
                dictionary
            }
            else -> null
        }
    }
internal val JSum.count: Int?
    get() {
        return when (this) {
            is JSum.arr -> {
                val arr: List<JSum> = this.arr
                arr.size
            }
            is JSum.obj -> {
                val obj: Map<String, JSum> = this.obj
                obj.size
            }
            else -> null
        }
    }
