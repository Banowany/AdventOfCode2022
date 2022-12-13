package day10

import java.lang.RuntimeException

private fun lineToInstruction(line: String): Instruction
{
    val parts = line.split(" ")
    return when(parts[0])
    {
        "addx" -> Add(parts[1].toInt())
        "noop" -> Noop()
        else -> throw RuntimeException()
    }
}
fun main()
{
    val inputReader = InputReader()
    val input = inputReader.readAsListOfLine("src/main/kotlin/day10/Data")

    val instructions = input.map { lineToInstruction(it) }

    val registerValueOnEveryCycle = mutableListOf<Int>(1)

    for (instruction in instructions)
    {
        instruction.perform(registerValueOnEveryCycle)
    }

    val specificCycles = mutableListOf<Int>(20, 60, 100, 140, 180, 220)

    println(specificCycles.map { it*registerValueOnEveryCycle[it-1] }.sum())

    val rowsNumber = (registerValueOnEveryCycle.size-1)/40

    val rows = mutableListOf<Row>()

    for (i in 1..rowsNumber)
        rows.add(Row())

    for (i in 0 until registerValueOnEveryCycle.size-1)
    {
        rows[i/40].draw(registerValueOnEveryCycle[i])
    }

    for (row in rows)
        println(row.rowString)

}