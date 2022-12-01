package day01

class MaxCaloriesFinder
{
    fun find(calories: List<Int>): Int
    {
        return calories.max()
    }
    fun findThree(calories: List<Int>): Triple<Int,Int,Int>
    {
        var first = calories[0]
        var second = calories[1]
        var third = calories[2]
        for(i in 3..calories.size-1)
        {
            if(calories[i]>first)
            {
                third=second
                second=first
                first=calories[i]
            }
            else if(calories[i]>second)
            {
                third=second
                second=calories[i]
            }
            else if(calories[i]>third)
            {
                third=calories[i]
            }
        }
        return Triple(first, second, third)
    }
}