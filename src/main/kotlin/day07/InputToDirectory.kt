package day07

class InputToDirectory
{
    private fun directoryCreator(newInput: List<String>):Directory
    {
        var currDirectory: Directory? = null
        for (line in newInput)
        {
            if (line == "..")
                currDirectory = currDirectory?.parent
            else if (line.all { c -> c.isDigit() })
                currDirectory?.size = currDirectory?.size?.plus(line.toLong())!!
            else
            {
                val directory = Directory(currDirectory, 0)
                currDirectory?.children?.add(directory)
                currDirectory = directory
            }
        }
        while (currDirectory?.parent != null)
        {
            currDirectory = currDirectory.parent
        }

        return currDirectory!!
    }
    fun map(input: List<String>): Directory
    {
        val newInput = mutableListOf<String>()
        for (line in input)
        {
            if (line == "$ ls" || line.substring(0,3) == "dir")
                //nothing
            else if (line.contains("$ cd"))
                newInput.add(line.split(" ")[2])
            else
                newInput.add(line.split(" ")[0])
        }
        return directoryCreator(newInput)
    }
}