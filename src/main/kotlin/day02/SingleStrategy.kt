package day02

data class SingleStrategy(
    val oponentChoose: Char,
    val myChoose: Char
) {
  fun scoreResult() : Int
  {
      var result = 0
      if(oponentChoose=='A')//rock
      {
          if (myChoose=='X')//rock
            result+=1+3
          if (myChoose=='Y')//paper
              result+=2+6
          if (myChoose=='Z')//scicors
              result+=3+0
      }
      if(oponentChoose=='B')//paper
      {
          if (myChoose=='X')//rock
              result+=1+0
          if (myChoose=='Y')//paper
              result+=2+3
          if (myChoose=='Z')//scicors
              result+=3+6
      }
      if(oponentChoose=='C')//scisors
      {
          if (myChoose=='X')//rock
              result+=1+6
          if (myChoose=='Y')//paper
              result+=2+0
          if (myChoose=='Z')//scicors
              result+=3+3
      }
      return result
  }
    fun scoreResultForPartTwo() : Int
    {
        var result = 0
        if(oponentChoose=='A')//rock
        {
            if (myChoose=='X')//loose
                result+=3+0
            if (myChoose=='Y')//draw
                result+=1+3
            if (myChoose=='Z')//win
                result+=2+6
        }
        if(oponentChoose=='B')//paper
        {
            if (myChoose=='X')//loose
                result+=1+0
            if (myChoose=='Y')//draw
                result+=2+3
            if (myChoose=='Z')//win
                result+=3+6
        }
        if(oponentChoose=='C')//scisors
        {
            if (myChoose=='X')//loose
                result+=2+0
            if (myChoose=='Y')//draw
                result+=3+3
            if (myChoose=='Z')//win
                result+=1+6
        }
        return result
    }

}