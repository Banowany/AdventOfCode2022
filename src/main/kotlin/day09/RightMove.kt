package day09

class RightMove(howMany: Int) : Move(howMany)
{
    override fun perform(head: Head, tail: Tail)
    {
        for (iterationNumber in 1..howMany)
        {
            head.moveRight()
            tail.update(head)
        }
    }

    override fun perform(head: Head, tails: List<Tail>) {
        for (iterationNumber in 1..howMany)
        {
            head.moveRight()
            tails[0].update(head)
            for (i in 1..8)
            {
                tails[i].update(tails[i-1])
            }
        }
    }
}