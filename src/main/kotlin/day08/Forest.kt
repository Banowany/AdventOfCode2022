package day08

data class Forest(
    val forestHeights: Array<IntArray>
)
{
    fun getMaxHeightsFromBottom(): Array<IntArray>
    {
        val maxHeights = Array(forestHeights.size){IntArray(forestHeights[0].size)}

        for (i in 0 until  forestHeights[0].size)
            maxHeights[forestHeights.size-1][i]=forestHeights[forestHeights.size-1][i]

        for (j in 0 until  forestHeights[0].size)
        {
            for (i in forestHeights.size-2 downTo 0)
                maxHeights[i][j]= maxOf(maxHeights[i+1][j], forestHeights[i][j])
        }

        return maxHeights
    }

    fun getMaxHeightsFromTop(): Array<IntArray>
    {
        val maxHeights = Array(forestHeights.size){IntArray(forestHeights[0].size)}

        for (i in 0 until  forestHeights[0].size)
            maxHeights[0][i]=forestHeights[0][i]

        for (j in 0 until  forestHeights[0].size)
        {
            for (i in 1 until forestHeights.size)
                maxHeights[i][j]= maxOf(maxHeights[i-1][j], forestHeights[i][j])
        }

        return maxHeights
    }

    fun getMaxHeightsFromLeft(): Array<IntArray>
    {
        val maxHeights = Array(forestHeights.size){IntArray(forestHeights[0].size)}

        for (i in 0 until  forestHeights.size)
            maxHeights[i][0]=forestHeights[i][0]

        for (i in 0 until  forestHeights.size)
        {
            for (j in 1 until forestHeights[0].size)
                maxHeights[i][j]= maxOf(maxHeights[i][j-1], forestHeights[i][j])
        }

        return maxHeights
    }

    fun getMaxHeightsFromRight(): Array<IntArray>
    {
        val maxHeights = Array(forestHeights.size){IntArray(forestHeights[0].size)}

        for (i in 0 until  forestHeights.size)
            maxHeights[i][forestHeights[0].size-1]=forestHeights[i][forestHeights[0].size-1]

        for (i in 0 until  forestHeights.size)
        {
            for (j in forestHeights[0].size-2 downTo 0)
                maxHeights[i][j]= maxOf(maxHeights[i][j+1], forestHeights[i][j])
        }

        return maxHeights
    }

    fun countVisibleTrees(): Int
    {
        val maxHeightsFromBottom = getMaxHeightsFromBottom()
        val maxHeightsFromTop = getMaxHeightsFromTop()
        val maxHeightsFromLeft = getMaxHeightsFromLeft()
        val maxHeightsFromRight = getMaxHeightsFromRight()

        var visibleTrees = 0

        for (i in 1..forestHeights.size-2)
            for (j in 1..forestHeights[0].size-2)
                if (forestHeights[i][j]>maxHeightsFromBottom[i+1][j] ||
                    forestHeights[i][j]>maxHeightsFromTop[i-1][j] ||
                    forestHeights[i][j]>maxHeightsFromLeft[i][j-1] ||
                    forestHeights[i][j]>maxHeightsFromRight[i][j+1])
                    visibleTrees++

        return 2*forestHeights.size+2*forestHeights[0].size+visibleTrees-4
    }

    fun getSingleScenicResult(i: Int, iIncrease: Int, j: Int, jIncrease:Int, basicHeight: Int): Int
    {
        if(i<0 || i==forestHeights.size)
            return 0
        if(j<0 || j==forestHeights[0].size)
            return 0
        if(forestHeights[i][j]>=basicHeight)
            return 1

        return getSingleScenicResult(i+iIncrease, iIncrease, j+jIncrease, jIncrease, basicHeight) + 1
    }
    fun findMaxScenicScore(): Int
    {
        var maxResult: Int = 0
        for (i in 1..forestHeights.size-2)
            for (j in 1..forestHeights[0].size-2)
                maxResult = maxOf(maxResult,
                    getSingleScenicResult(i-1,-1,j,0,forestHeights[i][j]) *
                            getSingleScenicResult(i+1,1,j,0,forestHeights[i][j]) *
                            getSingleScenicResult(i,0,j-1,-1,forestHeights[i][j])*
                            getSingleScenicResult(i,0,j+1,1,forestHeights[i][j]))
        return maxResult
    }
}
