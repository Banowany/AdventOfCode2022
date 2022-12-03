package day03

data class Group(
    val firstAllElements: String,
    val secondAllElements: String,
    val thirdAllElemnts: String
)
{
    private fun countElements(compartment: String) : Map<Char, Int>
    {
        val countedCompartment : MutableMap<Char, Int>
        countedCompartment = HashMap()

        for(c in compartment)
        {
            countedCompartment[c] =
                countedCompartment.getOrDefault(c, 0) + 1
        }

        return countedCompartment
    }

    fun getTheMostCommonElement() : Char
    {
        val countedFirstElements = countElements(firstAllElements)
        val countedSecondElements = countElements(secondAllElements)
        val countedThirdElements = countElements(thirdAllElemnts)

        val possibleElements = countedFirstElements.keys +
                countedSecondElements.keys + countedThirdElements.keys

        val countedCommonElements : MutableMap<Char, Int> = HashMap()
        for(el in possibleElements)
        {
            countedCommonElements[el] = minOf(
                countedFirstElements.getOrDefault(el, 0),
                countedSecondElements.getOrDefault(el, 0),
                countedThirdElements.getOrDefault(el, 0)
            )
        }

        val maxCommonElement = countedCommonElements.maxWith(
            Comparator { x, y -> x.value.compareTo(y.value)}).key

        return maxCommonElement
    }
}