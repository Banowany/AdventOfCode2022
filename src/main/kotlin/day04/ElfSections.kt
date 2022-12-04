package day04

data class ElfSections(val sectionsBegin: Int, val sectionsEnd: Int)
{
    fun contains(otherElfSection: ElfSections): Boolean
    {
        return sectionsBegin<=otherElfSection.sectionsBegin && otherElfSection.sectionsEnd<=sectionsEnd
    }
    fun notFullyContains(otherElfSection: ElfSections): Boolean
    {
        return (otherElfSection.sectionsBegin in sectionsBegin..sectionsEnd) ||
                (otherElfSection.sectionsEnd in sectionsBegin..sectionsEnd)
    }
}
