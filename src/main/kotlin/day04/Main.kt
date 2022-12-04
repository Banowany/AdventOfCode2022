package day04

private fun countPairsWithContaining(pairsOfElfSections: List<Pair<ElfSections, ElfSections>>): Long
{
    var counter : Long = 0
    for (pair in pairsOfElfSections)
        if (pair.first.contains(pair.second) || pair.second.contains(pair.first))
            counter++

    return counter
}

private fun countPairsWithNotFullyContaining(pairsOfElfSections: List<Pair<ElfSections, ElfSections>>): Long
{
    var counter : Long = 0
    for (pair in pairsOfElfSections)
        if (pair.first.notFullyContains(pair.second) || pair.second.notFullyContains(pair.first))
            counter++

    return counter
}

fun main()
{
    val inputReader = InputReader()
    val inputLines = inputReader.readAsListOfLine("/home/krzysztof/AdventOfCode/untitled/src/main/kotlin/day04/Data")

    val inputToElfSections = InputToElfSections()
    val pairsOfElfSections = inputToElfSections.handle(inputLines)

    println(countPairsWithContaining(pairsOfElfSections))
    println(countPairsWithNotFullyContaining(pairsOfElfSections))
}