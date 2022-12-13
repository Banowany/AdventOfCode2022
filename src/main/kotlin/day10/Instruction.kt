package day10

interface Instruction
{
    fun perform(registerValueOnEveryCycle: MutableList<Int>)
}