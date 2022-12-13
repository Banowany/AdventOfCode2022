package day13

import java.util.StringJoiner
import kotlin.math.min

class Packet(stringPacket: String)
{
    var isInt: Boolean = true
    var listContent: MutableList<Packet> = mutableListOf()
    var intContent: Int = 0

    init
    {
        //println(stringPacket)
        if(stringPacket == "[]")
        {
            isInt = true
            intContent = -1
        }
        else if (stringPacket.first()=='[')
        {
            isInt = false
            val tmp = stringPacket.substring(1, stringPacket.length-1)
            var tmp1: String = ""
            var deep: Int = 0
            for (sign in tmp)
            {
                if (sign==',' && deep == 0)
                {
                    listContent.add(Packet(tmp1))
                    tmp1 = ""
                }
                else
                {
                    tmp1+=sign
                    if (sign == '[')
                        deep++
                    else if (sign == ']')
                        deep--
                }
            }
            listContent.add(Packet(tmp1))
        }
        else
        {
            isInt = true
            intContent = stringPacket.toInt()
        }
    }

    override fun toString(): String
    {
        if (isInt)
            if (intContent==-1)
                return "[]"
            else
                return intContent.toString()
        else
        {
            val stringJoiner = StringJoiner(",")
            for (content in listContent)
                stringJoiner.add(content.toString())
            return "["+stringJoiner.toString()+"]"
        }
    }

    fun compareTo(other: Packet): Int
    {
        if (isInt && other.isInt)
            return other.intContent - intContent
        else if (!isInt && !other.isInt)
        {
            var i=0
            while (i< min(other.listContent.size, listContent.size))
            {
                val tmp = listContent[i].compareTo(other.listContent[i])
                if (tmp!=0)
                    return tmp
                i++
            }
            return other.listContent.size - listContent.size
        }
        else if (isInt)
        {
            val intAsList = Packet("[$intContent]")
            return intAsList.compareTo(other)
        }
        else
        {
            val intAsList = Packet("[${other.intContent}]")
            return compareTo(intAsList)
        }
    }
}