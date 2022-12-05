package day05

class InputToCratesStack
{
    private fun splintedLineToCratesStack(splintedLine: List<String>): CratesStack
    {
        val cratesStack = CratesStack()
        splintedLine.map { it[0] }.forEach(cratesStack::add)
        return cratesStack
    }

    fun map(input: List<String>): List<CratesStack>
    {
        return input.map { it.split(" ") }.map { splintedLineToCratesStack(it) }
    }
}