package day01

class InputToCalories
{
    fun getCalories(input: List<String>): List<Int>
    {
        val calories = arrayListOf<Int>()
        var totalCalories = 0
        for (line in input)
        {
            if(line.equals(""))
            {
                calories.add(totalCalories)
                totalCalories = 0
            }
            else
            {
                totalCalories += line.toInt()
            }
        }
        return calories
    }
}