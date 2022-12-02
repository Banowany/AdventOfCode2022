package day02

fun main()
{
    val lineInputReader = LineInputReader()
    val inputLines = lineInputReader.readFileAsLines("/home/krzysztof/AdventOfCode/untitled/src/main/kotlin/day02/Data")
    val lineToSingleStrategies = LineToSingleStrategies()
    val singleStrategies = lineToSingleStrategies.map(inputLines)
    println(singleStrategies.stream().map { it.scoreResult() }.toList().sum())
    println(singleStrategies.sumOf { it.scoreResultForPartTwo() })
}