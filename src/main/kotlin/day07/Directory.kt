package day07

data class Directory(
    val parent: Directory?,
    var size: Long
)
{
    val children = mutableListOf<Directory>()

    fun repair(): Long
    {
        var childrenSize: Long = 0
        if (children.isNotEmpty())
        {
            for (child in children)
            {
                childrenSize += child.repair()
            }
        }
        size+=childrenSize
        return size
    }

    fun sumOfSizes(atMost: Long): Long
    {
        var sum:Long = 0
        if (size<=atMost)
            sum+=size

        for (child in children)
        {
            sum+=child.sumOfSizes(atMost)
        }
        return sum
    }

    fun sizeOfMinimumCandidateToDelete(atLeast: Long): Long
    {
        var minSize:Long = Long.MAX_VALUE
        var tmp: Long

        for (child in children)
        {
            tmp = child.sizeOfMinimumCandidateToDelete(atLeast)
            if (tmp in atLeast until minSize)
            {
                minSize = tmp
            }
        }

        if (size in atLeast until minSize)
        {
            minSize = size
        }

        return minSize
    }
}
