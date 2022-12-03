package day03

fun main()
{
    val inputReader = InputReader()
    val input = inputReader.readAsListOfLine(
        "/home/krzysztof/AdventOfCode/untitled/src/main/kotlin/day03/Data")

    val inputToRucksacks = InputToRucksacks()
    val inputToGroups = InputToGroups()

    val rucksacks = inputToRucksacks.handle(input)
    val groups = inputToGroups.handle(input)

    val elementToPriority = ElementToPriority()
    elementToPriority.init()

    val sumOfPriorityOfCommonElement = rucksacks.sumOf {
        elementToPriority.getPriority(it.getTheMostCommonElement()) }

    val sumOfPriorityOfCommonElement2 = groups.sumOf {
        elementToPriority.getPriority(it.getTheMostCommonElement()) }

    println(sumOfPriorityOfCommonElement)
    println(sumOfPriorityOfCommonElement2)
}