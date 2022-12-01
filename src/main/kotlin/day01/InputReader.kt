package day01

import java.io.File

class InputReader
{
    fun readFileAsLines(fileName: String): List<String>
            = File(fileName).useLines { it.toList() }
}