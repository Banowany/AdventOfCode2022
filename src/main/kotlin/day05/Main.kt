package day05

fun main()
{
    val inputReader = InputReader()
    val stacksInput = inputReader.readAsListOfLine("/home/krzysztof/AdventOfCode/untitled/src/main/kotlin/day05/Stacks")
    val movesInput = inputReader.readAsListOfLine("/home/krzysztof/AdventOfCode/untitled/src/main/kotlin/day05/Moves")

    val cratesStacks = InputToCratesStack().map(stacksInput)
    val moves = InputToMoves().map(movesInput)


//    moves.forEach{it.perform(cratesStacks)}
    moves.forEach{it.performBetterMove(cratesStacks)}

    cratesStacks.forEach { print(it.peek()) }
}