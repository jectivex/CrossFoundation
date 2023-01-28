package CrossFoundation

// MARK: JSON
import kotlinx.serialization.*

// gryphon Xinsert: import kotlinx.serialization.json.JSON
@Serializable

sealed class JSum {
    class nul: JSum()
    class bol(val bol: Boolean): JSum()
    class num(val num: Double): JSum()
    class str(val str: String): JSum()
    class arr(val arr: List<JSum>): JSum()
    class obj(val obj: Map<String, JSum>): JSum()
}

typealias JObj = Map<String, JSum>

fun JSum.toJSON(): String {
    //kotlinx.serialization.json.JSON.stringify(JSum.serializer(), self)
    return ""
}
