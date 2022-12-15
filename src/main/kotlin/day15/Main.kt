package day15

import day12.Position
import kotlin.math.abs

typealias Coordinates = Pair<Int, Int>
private fun lineToPairOfCoordinates(line: String): Pair<Coordinates, Coordinates>
{
    val splitLine = line.split(": ")

    val sensor = splitLine[0].replace("Sensor at x=", "")
        .replace(", y=", " ").split(" ").map { it.toInt() }.toList()

    val beacon = splitLine[1].replace("closest beacon is at x=", "")
        .replace(", y=", " ").split(" ").map { it.toInt() }.toList()

    return Pair(Coordinates(sensor[0], sensor[1]), Coordinates(beacon[0], beacon[1]))
}

fun visitPlacesInRowWithGivenDistance(
    visitedPlaces: MutableSet<Coordinates>, curr: Coordinates,
    distance: Int
)
{
    for (rowDismissal in 0..distance)
    {
        if (curr.second-rowDismissal==2000000)
            for (column in curr.first-distance+rowDismissal..curr.first+distance-rowDismissal)
            {
                visitedPlaces.add(Position(column, curr.second-rowDismissal))
            }
        if (curr.second+rowDismissal==2000000)
            for (column in curr.first-distance+rowDismissal..curr.first+distance-rowDismissal)
            {
                visitedPlaces.add(Position(column, curr.second+rowDismissal))
            }
    }
}

fun main()
{
    val inputReader = InputReader()
    val input = inputReader.readAsListOfLine("src/main/kotlin/day15/Data")

    val sensorsAndBeacons = input.map { lineToPairOfCoordinates(it) }

    val placesWithoutBeacons = mutableSetOf<Coordinates>()
    for (pair in sensorsAndBeacons)
    {
        val sensor = pair.first
        val beacon = pair.second
        val distance = abs(sensor.first-beacon.first) + abs(sensor.second-beacon.second)
        visitPlacesInRowWithGivenDistance(placesWithoutBeacons, sensor, distance)
        //visitPlacesInRowWithGivenDistance(placesWithoutBeacons, sensor, distance, -1)
        placesWithoutBeacons.remove(beacon)
    }
    placesWithoutBeacons.count { it.second == 2000000 }.also { println(it) }
}