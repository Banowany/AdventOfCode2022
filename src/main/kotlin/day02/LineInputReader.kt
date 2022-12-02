package day02

import java.io.File

class LineInputReader
{
    fun readFileAsLines(fileName: String): List<String>
            = File(fileName).useLines { it.toList() }
}