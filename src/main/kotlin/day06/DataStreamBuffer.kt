package day06

data class DataStreamBuffer(
    val buffer: String
    )
{
    fun processedCharacters(markerSize: Int) : Int
    {
        for (i in 0..buffer.length-markerSize)
        {
            val marker = Marker(buffer.substring(i, i+markerSize))
            if (marker.hasUniqueCharacters())
                return i+markerSize
        }
        return buffer.length
    }
}
