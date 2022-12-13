package day12

import java.lang.RuntimeException
import java.util.PriorityQueue
import kotlin.math.abs

private fun isPlaceExist(place: Pair<Int, Int>, n: Int, m: Int): Boolean
{
    if (place.first<0 || place.first>=n)
        return false
    if (place.second<0 || place.second>=m)
        return false
    return true
}
private fun canMove(begin: Char, destination: Char): Boolean
{
    if (destination.code-begin.code<=1)
        return true
    return false
}

typealias Position = Pair<Int, Int>
fun shortPath(vs: Position, vk: Position, n: Int, m: Int, heightMap: List<List<Char>>): String
{
    val Q = PriorityQueue<Pair<Position, String>>(compareBy{it.second.length})
    val visited = mutableMapOf<Position, Boolean>()
    var vAndLength: Pair<Position, String>
    var v: Position
    var u: Position
    var length: String = ""

    Q.add(Pair(vs, heightMap[vs.first][vs.second].toString()))
    //visited[vs]=true

    while (Q.isNotEmpty())
    {
        vAndLength = Q.poll()
        v = vAndLength.first
        length = vAndLength.second

        //println(v)

        if(visited[v]!=null)
        {
            //println("XD")
            continue
        }
        else
            visited[v]=true


        if (v.first == vk.first && v.second==vk.second)
        {
            return length
        }
        //println("cos")

        val neighbours = mutableListOf<Position>(Position(v.first-1, v.second), Position(v.first+1, v.second),
            Position(v.first, v.second-1), Position(v.first, v.second+1))
        neighbours.removeIf { !isPlaceExist(it, n, m) }

        for (neighbour in neighbours)
        {
            if (canMove(heightMap[v.first][v.second],
                heightMap[neighbour.first][neighbour.second]))
                Q.add(Pair(neighbour, length+heightMap[neighbour.first][neighbour.second]))
        }
    }
    return ""
}

fun main()
{
    val inputReader = InputReader()
    val input = inputReader.readAsListOfLine("src/main/kotlin/day12/Data")

    val heightmap = input.map { it.toMutableList() }.toMutableList()
    var positionS: Position = Position(0, 0)
    var positionE: Position = Position(0, 0)

    for (i in heightmap.indices)
        for (j in heightmap[i].indices)
            when (heightmap[i][j])
            {
                'S' -> {
                    heightmap[i][j]='a'
                    positionS = Pair(i,j)
                }
                'E' -> {
                    heightmap[i][j]='z'
                    positionE = Pair(i,j)
                }
            }

    println(shortPath(vs = positionS, vk = positionE, n = heightmap.size, m = heightmap[0].size, heightMap = heightmap).length-1)

    var cos = mutableListOf<Position>()

    for (i in heightmap.indices)
        for (j in heightmap[i].indices)
            when (heightmap[i][j])
            {
                'a' -> cos.add(Position(i, j))
            }

    println(cos.map { shortPath(it, positionE, heightmap.size, heightmap[0].size, heightmap).length }
        .filterNot{it==0}.min()-1)
}