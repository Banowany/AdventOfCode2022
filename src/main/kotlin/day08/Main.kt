package day08

fun main()
{
    val inputReader = InputReader()
    val input = inputReader.readAsListOfLine("src/main/kotlin/day08/Data")

    val forestArray2D = input.map { it.map { it.code-'0'.code }.toIntArray() }.toTypedArray()

    val forest = Forest(forestArray2D)

    println(forest.countVisibleTrees())
    println(forest.findMaxScenicScore())
}