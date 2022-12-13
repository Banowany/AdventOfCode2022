package day11

import day10.InputReader

private fun threeLinesToMonkey(line1: String, line2: String, line3: String): Monkey
{
    val items: MutableList<Long> = line1.split(" ").map { it.toLong() }.toMutableList()
    val parts2 = line2.split(" ")
    val operationSign = parts2[0][0]
    val operationNumber = parts2[1].toLong()
    val parts3 = line3.split(" ")
    val testNumber = parts3[0].toLong()
    val ifTestTrue = parts3[1].toInt()
    val ifTestFalse = parts3[2].toInt()

    return Monkey(items, operationSign, operationNumber, testNumber, ifTestTrue, ifTestFalse)
}
private fun twoMaxes(numbers: List<Long>): Pair<Long, Long>
{
    var maxOne = 0L
    var maxTwo = 0L
    for (n in numbers) {
        if (maxOne < n) {
            maxTwo = maxOne
            maxOne = n
        } else if (maxTwo < n) {
            maxTwo = n
        }
    }
    return Pair(maxOne, maxTwo)
}
fun main()
{
    val inputReader = InputReader()
    val input = inputReader.readAsListOfLine("src/main/kotlin/day11/BetterData")

    val monkeys = mutableListOf<Monkey>()
    for (i in input.indices step 3)
        monkeys.add(threeLinesToMonkey(input[i], input[i+1], input[i+2]))

//    for (i in 1..20)
//    {
//        for (monkey in monkeys)
//            monkey.inspection(monkeys)
//        for (monkey in monkeys)
//            println(monkey.items)
//
//        println()
//    }


    val lcm = monkeys.map { it.testNumber }.reduce { acc, bigInteger -> acc * bigInteger }

    println(lcm)

    for (i in 1..10000)
    {
        for (monkey in monkeys)
            monkey.inspection(monkeys, lcm)
        if (i%1000==0)
        {
            for (monkey in monkeys)
                println(monkey.timesOfThrow)

            println()
        }

    }

    val twoMaxTimes = twoMaxes(monkeys.map { it.timesOfThrow })


//    for (monkey in monkeys)
//        println(monkey.timesOfThrow)
    println(twoMaxTimes)
    println(twoMaxTimes.first*twoMaxTimes.second)
}
