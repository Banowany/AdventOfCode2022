package day14

import java.io.File

class InputReader
{
    fun readAsListOfLine(fileName: String): List<String>
            = File(fileName).useLines { it.toList() }
}