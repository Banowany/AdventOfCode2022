package day13

import java.util.Stack

private fun lineToPacket(line: String): Packet?
{
    if (line=="")
        return null

    return Packet(line)
}

fun main()
{
    val inputReader = InputReader()
    val input = inputReader.readAsListOfLine("src/main/kotlin/day13/Data")

    val packets = input.mapNotNull { lineToPacket(it) }.toMutableList()
    val pairsOfPackets = mutableListOf<Pair<Packet, Packet>>()
    for (index in packets.indices step 2)
    {
        pairsOfPackets.add(Pair(packets[index], packets[index+1]))
    }



    var sum = 0
    for (index in pairsOfPackets.indices)
    {
        pairsOfPackets[index]
            .first
            .compareTo(
                pairsOfPackets[index]
                .second)
            .also {
                if (it>0)
                    sum+=index+1
            }
    }
    println(sum)

    packets.add(Packet("[[2]]"))
    packets.add(Packet(("[[6]]")))

    packets.sortWith(Comparator { t, t2 -> t2.compareTo(t) })
    var decoderKey = 1
    for (index in packets.indices)
    {
        if (packets[index].compareTo(Packet("[[2]]"))==0)
            decoderKey*=index+1
        if (packets[index].compareTo(Packet("[[6]]"))==0)
            decoderKey*=index+1
    }
    println(decoderKey)
}