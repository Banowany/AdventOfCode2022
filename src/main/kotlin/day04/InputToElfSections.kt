package day04

class InputToElfSections
{
    private fun stringRangeToElfSections(range: String): ElfSections
    {
        val begAndEndSectionsAsString = range.split("-")
        return ElfSections(begAndEndSectionsAsString[0].toInt(), begAndEndSectionsAsString[1].toInt())
    }

    private fun pairOfStringRangeToPairOfElfSections(pairOfRange: Pair<String, String>): Pair<ElfSections, ElfSections>
    {
        return Pair(stringRangeToElfSections(pairOfRange.first), stringRangeToElfSections(pairOfRange.second))
    }

    fun handle(input: List<String>): List<Pair<ElfSections, ElfSections>>
    {
        return input.stream().map { it.split(",") }.map { list -> Pair(list[0], list[1]) }
            .map { pairOfStringRangeToPairOfElfSections(it) }.toList()
    }
}