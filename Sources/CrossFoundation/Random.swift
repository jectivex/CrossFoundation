// MARK: Random

/// A cross-platform random number generator
public class Random {
    /// The shared random singleton
    public static let shared = Random()

    private init() {
    }

    #if SKIP
    //let random: java.util.Random = java.util.Random()
    let random: java.util.Random = java.security.SecureRandom()
    #else
    var rng: RandomNumberGenerator = SystemRandomNumberGenerator()
    #endif

    public func randomDouble() -> Double {
        #if SKIP
        // Returns the next pseudorandom, uniformly distributed double value between 0.0 and 1.0 from this random number generator's sequence.
        // The general contract of nextDouble is that one double value, chosen (approximately) uniformly from the range 0.0d (inclusive) to 1.0d (exclusive), is pseudorandomly generated and returned.
        return random.nextDouble()
        #else
        return Double.random(in: 0..<1, using: &rng)
        #endif
    }
}

