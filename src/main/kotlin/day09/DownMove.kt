package day09

class DownMove(howMany: Int) : Move(howMany)
{
    override fun perform(head: Head, tail: Tail)
    {
        for (iterationNumber in 1..howMany)
        {
            head.moveDown()
            tail.update(head)
        }
    }

    override fun perform(head: Head, tails: List<Tail>) {
        for (iterationNumber in 1..howMany)
        {
            head.moveDown()
            tails[0].update(head)
            for (i in 1..8)
            {
                tails[i].update(tails[i-1])
            }
        }
    }
}