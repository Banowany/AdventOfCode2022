package day01

fun main()
{
    val inputReader = InputReader()
    val input = inputReader.readFileAsLines("/home/krzysztof/AdventOfCode/untitled/src/main/kotlin/day01/Data")
    val inputToCalories = InputToCalories()
    val calories = inputToCalories.getCalories(input)
    val maxCaloriesFinder = MaxCaloriesFinder()
    println(maxCaloriesFinder.find(calories))
    println(maxCaloriesFinder.findThree(calories).toList().sum())
}