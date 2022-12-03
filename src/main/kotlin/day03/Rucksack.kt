package day03

data class Rucksack(
    val firstCompartment: String,
    val secondCompartment: String
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
        val countedFirstCompartmentElement = countElements(firstCompartment)
        val countedSecondCompartmentElement = countElements(secondCompartment)

        val possibleElements = countedFirstCompartmentElement.keys +
                countedSecondCompartmentElement.keys

        val countedCommonElements : MutableMap<Char, Int> = HashMap()
        for(el in possibleElements)
        {
            countedCommonElements[el] = minOf(
                countedFirstCompartmentElement.getOrDefault(el, 0),
                countedSecondCompartmentElement.getOrDefault(el, 0)
            )
        }

        val maxCommonElement = countedCommonElements.maxWith(
            Comparator { x, y -> x.value.compareTo(y.value)}).key

        return maxCommonElement
    }
}