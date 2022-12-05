package day05

import java.util.Stack

class CratesStack
{
    private val stack = Stack<Char>()

    fun add(crate: Char)
    {
        stack.add(crate)
    }

    fun moveCratesToOther(other: CratesStack, howMany: Int)
    {
        for (i in 1..howMany)
        {
            other.add(stack.pop())
        }
    }

    fun betterMoveCratesToOther(other: CratesStack, howMany: Int)
    {
        val tmpStack = Stack<Char>()

        for (i in 1..howMany)
        {
            tmpStack.add(stack.pop())
        }
        for (i in 1..howMany)
        {
            other.add(tmpStack.pop())
        }
    }

    fun peek() : Char
    {
        return stack.peek()
    }

    override fun toString(): String
    {
        return stack.toString()
    }
}