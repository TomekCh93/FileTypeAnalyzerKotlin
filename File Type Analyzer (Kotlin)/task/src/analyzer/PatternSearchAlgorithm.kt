package analyzer

interface PatternSearchAlgorithm {
    fun containsPattern(text: String, pattern: String): Int
    fun checkFileSupport(type: String): Boolean
}