package day06

data class Marker(val markerCharacters: String)
{
    fun hasUniqueCharacters(): Boolean
    {
        val characters = IntArray(256)
        for (mc in markerCharacters)
        {
            characters[mc.code]++
        }
        for (c in characters)
            if (c > 1)
                return false
        return true
    }
}