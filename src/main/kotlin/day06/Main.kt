package day06

fun main()
{
    val inputReader = InputReader()
    val input = inputReader.readAsListOfLine("/home/krzysztof/AdventOfCode/untitled/src/main/kotlin/day06/Data")

    val buffers = input.map { DataStreamBuffer(it) }

    buffers.forEach{ println(it.processedCharacters(14)) }
}