package day07

fun main()
{
    val inputReader = InputReader()
    val input = inputReader.readAsListOfLine("src/main/kotlin/day07/Data")

    val inputToDirectory = InputToDirectory()
    val directoryRoot = inputToDirectory.map(input)

    directoryRoot.repair()
    println(directoryRoot.sumOfSizes(100000))
    println(directoryRoot.sizeOfMinimumCandidateToDelete(30000000-70000000+directoryRoot.size))
}