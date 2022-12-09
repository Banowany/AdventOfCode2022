package day09

import kotlin.math.abs

class Tail: Rope()
{
    val visitedPositions = mutableSetOf<Position>(position)

    private fun getCorrectStepInAxis(diffInAxis: Int): Int
    {
        if(diffInAxis<0)
            return -1
        if (diffInAxis>0)
            return 1
        return 0
    }
    fun update(head: Rope)
    {
        val diffInX = head.position.x - position.x
        val diffInY = head.position.y - position.y

        val stepInX = getCorrectStepInAxis(diffInX)
        val stepInY = getCorrectStepInAxis(diffInY)

        if(abs(diffInX) > 1 || abs(diffInY) > 1)
        {
            position = Position(position.x+stepInX, position.y+stepInY)
        }

//        if (abs(diffInX)> 1 && abs(diffInY)==1)
//        {
//            val stepX = diffInX/abs(diffInX)
//            val stepY = diffInY/abs(diffInY)
//            position = Position(position.x+stepX, position.y+stepY)
//        }
//        else if(abs(diffInX)>1)
//        {
//            val step = diffInX/abs(diffInX)
//            position = Position(position.x+step, position.y)
//        }
//        else if (abs(diffInY)>1 && abs(diffInX)==1)
//        {
//            val stepX = diffInX/abs(diffInX)
//            val stepY = diffInY/abs(diffInY)
//            position = Position(position.x+stepX, position.y+stepY)
//        }
//        else if(abs(diffInY)>1)
//        {
//            val step = diffInY/abs(diffInY)
//            position = Position(position.x, position.y+step)
//        }
        
        visitedPositions.add(position)
        //println("Tail ${position.x} ${position.y}")
    }

    fun visited(): Int
    {
        return visitedPositions.size
    }
}