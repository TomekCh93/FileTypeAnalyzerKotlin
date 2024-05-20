package analyzer

class NaivePatternSearchAlgorithm : PatternSearchAlgorithm {
    override fun containsPattern(text: String, pattern: String): Int {
        for (i in 0 until text.length - pattern.length + 1) {
            if (text.substring(i, i + pattern.length) == pattern) {
                return 1
            }
        }
        return -1
    }

    override fun checkFileSupport(type: String): Boolean {
        //todo
        return false
    }

}
