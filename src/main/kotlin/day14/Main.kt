package day14

import kotlin.math.max
import kotlin.math.min

private fun isExistInScan(x: Int, y:Int, scan: Array<CharArray>): Boolean
{
    if (scan.size<=y || scan[0].size<=x)
        return false
    if (y<0 || x<0)
        return false
    return true
}
private fun dropUnitOfSand(x: Int, y: Int, scan: Array<CharArray>): Boolean
{
    if(!isExistInScan(x, y+1, scan)) return false

    if (scan[y+1][x]=='.') return dropUnitOfSand(x, y+1, scan)

    if(!isExistInScan(x-1, y+1, scan)) return false

    if (scan[y+1][x-1]=='.') return dropUnitOfSand(x-1, y+1, scan)

    if(!isExistInScan(x+1, y+1, scan)) return false

    if (scan[y+1][x+1]=='.') return dropUnitOfSand(x+1, y+1, scan)

    scan[y][x] = 'o'

    return true
}

private fun isExistInScan2(x: Int, y:Int, scan: MutableList<MutableList<Char>>): Boolean
{
    if (scan.size<=y || y<0)
        return false
    if (scan[y].size<=x)
    {
        val diff = x - scan[y].size + 1
        for (i in 1..diff)
            scan[y].add('.')
    }
    return true
}

private fun dropUnitOfSand2(x: Int, y: Int, scan: MutableList<MutableList<Char>>): Boolean
{
    //jesli jestem na 500,0 i jest tam cos to false
    //jesli pod spodem powietrze to ide tam
    //jesli nie moege to ide w lewo
    //jesli nie moge to ide w prawo
    //jesli brakuje miesca w x to uzupełniamy kropkami (zakladam ze nie musze wchodzic na ujemne)

    if (scan[y][x]=='o') return false

    if(isExistInScan2(x, y+1, scan) && scan[y+1][x]=='.')
        return dropUnitOfSand2(x, y+1, scan)

    if(isExistInScan2(x-1, y+1, scan) && scan[y+1][x-1]=='.')
        return dropUnitOfSand2(x-1, y+1, scan)

    if(isExistInScan2(x+1, y+1, scan) && scan[y+1][x+1]=='.')
        return dropUnitOfSand2(x+1, y+1, scan)

    scan[y][x] = 'o'

    return true
}

fun main()
{
    val inputReader = InputReader()
    val input = inputReader.readAsListOfLine("src/main/kotlin/day14/Data")

    val rocks = input
        .map { line -> line.split(" -> ")
            .map { coordinates -> coordinates.split(",")
                .map { number -> number.toInt() }}}

    var xMax = Int.MIN_VALUE
    var yMax = Int.MIN_VALUE

    for (path in rocks)
        for (coordinates in path)
        {
            xMax = if (xMax<coordinates[0]) coordinates[0] else xMax
            yMax = if (yMax<coordinates[1]) coordinates[1] else yMax
        }

    val scan = Array(yMax+1){CharArray(xMax+1) }
    for (level in scan.indices)
    {
        scan[level].fill('.')
    }

    for (path in rocks)
        for (coordinatesIndex in 0 until path.size-1)
        {
            if (path[coordinatesIndex][0]==path[coordinatesIndex+1][0])//x sa rowne
            {
                val x = path[coordinatesIndex][0]
                val yFrom = path[coordinatesIndex][1]
                val yTo = path[coordinatesIndex+1][1]
                val from = min(yFrom, yTo)
                val to = max(yFrom, yTo)
                var i = from
                while (i<=to)
                {
                    scan[i][x] = '#'
                    i++
                }
            }
            else//y sa rowne
            {
                val y = path[coordinatesIndex][1]
                val xFrom = path[coordinatesIndex][0]
                val xTo = path[coordinatesIndex+1][0]
                val from = min(xFrom, xTo)
                val to = max(xFrom, xTo)
                var i = from
                while (i<=to)
                {
                    scan[y][i] = '#'
                    i++
                }
            }
        }

    val scan2 = scan.map { it.toMutableList() }.toMutableList()
    val yLevelPlusOne = mutableListOf<Char>()
    scan2.add(yLevelPlusOne)

    var counter = 0
    while (dropUnitOfSand(500, 0, scan))
        counter++

    println(counter)

    counter = 0
    while (dropUnitOfSand2(500, 0, scan2))
        counter++

    println(counter)
}