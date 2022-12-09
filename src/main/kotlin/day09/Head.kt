package day09

class Head: Rope()
{
    fun moveRight()
    {
        position = Position(position.x+1, position.y)
        //println("Head ${position.x} ${position.y}")
    }

    fun moveLeft()
    {
        position = Position(position.x-1, position.y)
        //println("Head ${position.x} ${position.y}")
    }

    fun moveUp()
    {
        position = Position(position.x, position.y+1)
        //println("Head ${position.x} ${position.y}")
    }

    fun moveDown()
    {
        position = Position(position.x, position.y-1)
        //println("Head ${position.x} ${position.y}")
    }
}