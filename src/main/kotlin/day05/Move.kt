package day05

data class Move(
    val howManyCrates: Int,
    val fromStack: Int,
    val toStack: Int
)
{
    fun perform(cratesStacks: List<CratesStack>)
    {
        cratesStacks[fromStack-1].moveCratesToOther(cratesStacks[toStack-1], howManyCrates)
    }

    fun performBetterMove(cratesStacks: List<CratesStack>)
    {
        cratesStacks[fromStack-1].betterMoveCratesToOther(cratesStacks[toStack-1], howManyCrates)
    }
}
