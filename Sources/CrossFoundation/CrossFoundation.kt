package CrossFoundation

open class CrossFoundationTestHarness {
    companion object {
        fun crossFoundationTests() {
            assert(1 == 1)
        }

        fun crossFoundationAsyncTests() {
            assert(2 == 2)
        }
    }

    constructor() {
    }
}
