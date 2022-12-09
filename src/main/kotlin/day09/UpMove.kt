package day09

class UpMove(howMany: Int) : Move(howMany)
{
    override fun perform(head: Head, tail: Tail)
    {
        for (iterationNumber in 1..howMany)
        {
            head.moveUp()
            tail.update(head)
        }
    }

    override fun perform(head: Head, tails: List<Tail>) {
        for (iterationNumber in 1..howMany)
        {
            head.moveUp()
            tails[0].update(head)
            for (i in 1..8)
            {
                tails[i].update(tails[i-1])
            }
        }
    }
}