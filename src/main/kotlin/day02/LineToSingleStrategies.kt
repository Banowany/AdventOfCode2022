package day02

class LineToSingleStrategies
{
    fun map(inputLines: List<String>) : List<SingleStrategy>
    {
        val singleStrategies = ArrayList<SingleStrategy>()
        for(line in inputLines)
        {
            singleStrategies.add(SingleStrategy(line[0], line[2]))
        }
        return singleStrategies
    }
}