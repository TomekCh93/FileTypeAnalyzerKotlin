package analyzer

class RabinKarpAlgorithmUsingRollingHash : PatternSearchAlgorithm {
    override fun containsPattern(text: String, pattern: String): Int {
        if (text.length < pattern.length) {
            return 0
        }

        var hash1 = 0
        var hash2 = 0

        for (i in pattern.indices) {
            hash1 += pattern[i] - 'A'
            hash2 += text[i] - 'A'
        }

        var j = 0

        for (i in 0..text.length - pattern.length) {
            if (hash2 == hash1) {
                j = 0
                while (j < pattern.length && pattern[j] == text[i + j]) {
                    j++
                }
            }

            if (j == pattern.length) {
                return 1
            }
            if (i == text.length - pattern.length) break

            hash2 = hash2 - (text[i] - 'A') + (text[i + pattern.length] - 'A')
        }
        return 0
    }


    override fun checkFileSupport(type: String): Boolean {
        //todo
        return false
    }
}