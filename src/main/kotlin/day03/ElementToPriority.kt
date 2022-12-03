package day03

class ElementToPriority
{
    private val elementPriorities : MutableMap<Char, Int> = HashMap()

    fun init()
    {
        var i = 1
        var c : Char = 'a'
        while (c<='z')
        {
            elementPriorities[c] = i
            i++
            c++
        }

        c='A'
        while (c<='Z')
        {
            elementPriorities[c] = i
            i++
            c++
        }
    }

    fun getPriority(c : Char) : Int
    {
        return elementPriorities[c]!!
    }
}