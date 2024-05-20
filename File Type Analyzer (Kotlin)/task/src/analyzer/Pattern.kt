package analyzer

data class Pattern(
    val priority: Int,
    val keyword: String,
    val description: String,
    val fileName: String? = null
)