package day15

import kotlin.math.abs

private fun lineToPairOfCoordinates(line: String): Pair<Coordinates, Coordinates>
{
    val splitLine = line.split(": ")

    val sensor = splitLine[0].replace("Sensor at x=", "")
        .replace(", y=", " ").split(" ").map { it.toInt() }.toList()

    val beacon = splitLine[1].replace("closest beacon is at x=", "")
        .replace(", y=", " ").split(" ").map { it.toInt() }.toList()

    return Pair(Coordinates(sensor[0], sensor[1]), Coordinates(beacon[0], beacon[1]))
}

fun main()
{
    val MAXSIZE = 4000000
    val inputReader = InputReader()
    val input = inputReader.readAsListOfLine("src/main/kotlin/day15/Data")

    val sensorsAndBeacons = input.map { lineToPairOfCoordinates(it) }
    val safeRangesByRow = Array<MutableList<IntRange>>(MAXSIZE+1){ mutableListOf() }

//    for (pair in sensorsAndBeacons)
//    {
//        val sensor = pair.first
//        val beacon = pair.second
//        val dstX = abs(beacon.first - sensor.first)
//        val dstY = abs(beacon.second - sensor.second)
//        val dst = dstX + dstY
//        //curr.first-distance+rowDismissal..curr.first+distance-rowDismissal
//        for (rowDismissal in -dst..dst)
//        {
//            if(sensor.second+rowDismissal in 0..MAXSIZE)
//                safeRangesByRow[sensor.second+rowDismissal].add(
//                    sensor.first-dst+rowDismissal..sensor.first+dst-rowDismissal)
//        }
//    }
    sensorsAndBeacons.forEach{
        val sensor = it.first
        val beacon = it.second
        val dst = abs(beacon.first - sensor.first) + abs(beacon.second - sensor.second)

        for (y in 0..MAXSIZE)
        {
            val dstInY = abs(sensor.second - y)
            val width = dst - dstInY

            if (width>=0)
            {
                safeRangesByRow[y].add(sensor.first-width..sensor.first+width)
            }
        }
    }

    safeRangesByRow.forEachIndexed{
        i, safeRanges ->

        var lastEnd = 0
        //println(lastEnd)

        //safeRanges.sortBy { it.last }
        safeRanges.sortBy { it.first }
//        print(i)
//        safeRanges.forEach{ print("[${it.first}, ${it.last}] ") }
//        println()
        for (range in safeRanges)
        {
            if (i==11)
            {
                print("")
            }
            if (lastEnd<range.first)
            {
                println((range.first - 1).toBigInteger() * 4000000.toBigInteger() + i.toBigInteger())
                return
            }
            if (range.last > lastEnd)
            {
                lastEnd = range.last
            }
        }
        if(lastEnd<MAXSIZE)
        {
            println((lastEnd + 1).toBigInteger() * 4000000.toBigInteger() + i.toBigInteger())
            return
        }
    }
    println("nic nie znalazlem")
}