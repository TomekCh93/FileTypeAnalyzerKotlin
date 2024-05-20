package analyzer

import java.io.File

fun main(args: Array<String>) {
    val filePath = args[0]
    val patternDb = args[1]
    println(filePath)
    println(patternDb)
    val patterns = readPatterns(patternDb)
    val file = File(filePath)

    val naiveAlgorithm = NaivePatternSearchAlgorithm()
    val rabinKarpAlgorithm = RabinKarpAlgorithmUsingRollingHash()
    val kmpAlgorithm = KMPPatternSearchAlgorithm()

    val traverseFileList = FileProcessor(rabinKarpAlgorithm).traverseFileList(file.listFiles(), patterns)
    val sortedPatterns = traverseFileList.sortedBy { it.priority }
    sortedPatterns.forEach { pattern ->
        println("${pattern.fileName}: ${pattern.description}")
    }

}

fun readPatterns(patternsFilePath: String): List<Pattern> {
    val dbFile = File(patternsFilePath)
    val patterns = mutableListOf<Pattern>()
    dbFile.forEachLine { line ->
        val tokens = line.split(";")
        if (tokens.size == 3) {
            val priority = tokens[0].toIntOrNull() ?: 0
            val keyword = tokens[1].trim('"')
            val description = tokens[2].trim('"')
            patterns.add(Pattern(priority, keyword, description))
        }
    }
    return patterns
}

