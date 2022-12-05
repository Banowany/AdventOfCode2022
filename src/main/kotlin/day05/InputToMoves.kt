package day05

class InputToMoves
{
    private fun splintedLineToMoves(splintedLine: List<String>) : Move
    {
        return Move(splintedLine[0].toInt(), splintedLine[1].toInt(), splintedLine[2].toInt())
    }

    fun map(input: List<String>): List<Move>
    {
        return input
            .map { it.replace("move ", "") }
            .map { it.replace("from ", "") }
            .map { it.replace("to ", "") }
            .map { it.split(" ") }
            .map { splintedLineToMoves(it) }
    }
}