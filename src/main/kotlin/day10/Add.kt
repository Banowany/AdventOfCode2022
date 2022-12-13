package day10

class Add(private val value: Int) : Instruction
{
    override fun perform(registerValueOnEveryCycle: MutableList<Int>)
    {
        val lastValue = registerValueOnEveryCycle.last()
        registerValueOnEveryCycle.add(lastValue)
        registerValueOnEveryCycle.add(lastValue+value)
    }
}