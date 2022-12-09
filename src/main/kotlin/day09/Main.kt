package day09

private fun lineToMove(line: String): Move
{
    val parts = line.split(" ")
    val direction = parts[0]
    val howMany = parts[1].toInt()

    return when(direction)
    {
        "R" -> RightMove(howMany)
        "L" -> LeftMove(howMany)
        "U" -> UpMove(howMany)
        else -> DownMove(howMany)
    }
}
fun main()
{
    val inputReader = InputReader()
    val input = inputReader.readAsListOfLine("src/main/kotlin/day09/Data")

    val moves = input.map { lineToMove(it) }

    val head = Head()
    val tail = Tail()

    for (move in moves)
    {
        move.perform(head, tail)
    }

    println(tail.visited())

    val head1 = Head()
    val tail1 = mutableListOf<Tail>()

    for(i in 1..9) {
        tail1.add(Tail())
    }

    for (move in moves)
    {
        move.perform(head1, tail1)
    }

    println(tail1[8].visited())
}