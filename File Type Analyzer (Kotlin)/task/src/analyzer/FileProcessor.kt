package analyzer

import java.io.File

class FileProcessor(private val algorithm: PatternSearchAlgorithm) {

    fun traverseFileList(files: Array<File?>, patterns: List<Pattern>): List<Pattern> {
        val matchedPatterns = mutableListOf<Pattern>()
        for (file in files) {

            patterns.forEach { pattern ->
                val containsPattern =
                    algorithm.containsPattern(file!!.readText(), pattern.keyword)

                if (containsPattern == 1) {

                    matchedPatterns.add(
                        Pattern(
                            fileName = file.name,
                            description = pattern.description,
                            keyword = pattern.keyword,
                            priority = pattern.priority
                        )
                    )
                } else {
                    matchedPatterns.add(
                        Pattern(
                            fileName = file.name,
                            description = "Unknown file type",
                            keyword = pattern.keyword,
                            priority = 99
                        )
                    )
                }
            }
        }
        return matchedPatterns
    }
}