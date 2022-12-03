package day03

class InputToRucksacks
{
    private fun stringToRucksack(string: String) : Rucksack
    {
        val full = string.length
        val half = full/2

        return Rucksack(string.substring(0, half),
        string.substring(half, full))
    }

    fun handle(input : List<String>) : List<Rucksack>
    {
        //rozmiar 4
        // 4/2 = 2
        // 0 to 1, 2 to 3

        return input.map{stringToRucksack(it)}
    }
}