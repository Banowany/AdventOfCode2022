package day03

class InputToGroups
{
    fun handle(input : List<String>): List<Group>
    {
        val groups: MutableList<Group> = ArrayList()
        for (i in 0 until input.size step 3)
        {
            groups.add(Group(input[i], input[i+1], input[i+2]))
        }
        return groups
    }
}