package day11

class Monkey(
    val items: MutableList<Long>,
    val operationSign: Char,
    val operationNumber: Long,
    val testNumber: Long,
    val ifTestTrue: Int,
    val ifTestFalse: Int
)
{
    var timesOfThrow: Long = 0L
    private fun singleInspection(monkeyList: List<Monkey>, M: Long, item: Long)
    {

        var newItem: Long = when (operationSign) {
            '+' -> (item + operationNumber)
            '^' -> (item*item)
            else -> (item * operationNumber)
        }

        newItem = newItem%M
        //newItem /= 3

        if (newItem % testNumber == 0L)
        {
            monkeyList[ifTestTrue].items.add(newItem)
        }
        else
        {
            monkeyList[ifTestFalse].items.add(newItem)
        }
        timesOfThrow++
    }
    fun inspection(monkeyList: List<Monkey>, maxItemValue: Long)
    {
        for (item in items)
            singleInspection(monkeyList, maxItemValue, item)

        items.clear()
    }
}