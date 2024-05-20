package analyzer

class KMPPatternSearchAlgorithm : PatternSearchAlgorithm {
    override fun containsPattern(text: String, pattern: String): Int {
        val lpsTable = getLPSTable(pattern)
        var i = 0
        var j = 0
        while (i < text.length) {
            if (text[i] == pattern[j]) {
                i++
                j++
            } else {
                if (j != 0) {
                    j = lpsTable[j - 1]
                } else {
                    i++
                }
            }

            if (j == pattern.length) {
                return 1
            }
        }
        return 0
    }

    private fun getLPSTable(pattern: String): IntArray {
        val len = pattern.length
        val lps = IntArray(len)
        var prevLps = 0
        var i = 1
        while (i < len) {
            if (pattern[i] == pattern[prevLps]) {
                prevLps++
                lps[i] = prevLps
                i++
            } else {
                if (prevLps != 0) {
                    prevLps = lps[prevLps - 1]
                } else {
                    lps[i] = 0
                    i++
                }
            }
        }
        return lps
    }

    override fun checkFileSupport(type: String): Boolean {
        //todo
        return false
    }
}