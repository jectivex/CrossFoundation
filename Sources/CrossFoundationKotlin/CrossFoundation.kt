package CrossFoundation

import CrossFile.*

open class CrossFoundation {
    constructor() {
    }

    open fun importantFilesExist(): Boolean {
        return CrossFile().exists("/dev/null") == true
    }
}
