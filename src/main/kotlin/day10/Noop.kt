package day10

class Noop : Instruction {
    override fun perform(registerValueOnEveryCycle: MutableList<Int>)
    {
        registerValueOnEveryCycle.add(registerValueOnEveryCycle.last())
    }
}