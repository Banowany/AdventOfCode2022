package day10

class Row
{
    var rowString = ""

    fun draw(crtPosition: Int)
    {
        val drawingPlace = rowString.length
        rowString += if(drawingPlace in crtPosition-1..crtPosition+1)
            "#"
        else
            "."
    }
}