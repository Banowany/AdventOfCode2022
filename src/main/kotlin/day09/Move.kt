package day09

abstract class Move(val howMany: Int)
{
    abstract fun perform(head: Head, tail: Tail)
    abstract fun perform(head: Head, tails: List<Tail>)
}