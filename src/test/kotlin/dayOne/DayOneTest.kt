package dayOne

import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*

class DayOneTest {
    val subject: DayOne = DayOne()

    @Nested
    inner class GetInput {
        @Test
        fun `It gets the input from the file successfully`() {
            val input = subject.getInput()
            assertEquals("6529", input[0])
        }
    }

    @Nested
    inner class ParseInput {
        @Test
        fun `Given empty input, return empty list`() {
            val input: List<String> = emptyList()
            val result = subject.parseInput(input)
            val expected: List<Elf> = emptyList()
            assertEquals(expected, result)
        }

        @Test
        fun `Given input with only one line, return single elf list`() {
            val input: List<String> = listOf("123")
            val result = subject.parseInput(input)
            val expected = listOf(Elf(listOf(123)))
            assertEquals(expected, result)
        }

        @Test
        fun `Given input with only multiple lines for one elf, return single elf`() {
            val input: List<String> = listOf("123", "456", "789")
            val result = subject.parseInput(input)
            val expected = listOf(Elf(listOf(123, 456, 789)))
            assertEquals(expected, result)
        }

        @Test
        fun `Given input with only multiple elves, return elf list`() {
            val input: List<String> = listOf("123", "456", "789", "", "987", "654", "321")
            val result = subject.parseInput(input)
            val expected = listOf(Elf(listOf(123, 456, 789)), Elf(listOf(987, 654, 321)))
            assertEquals(expected, result)
        }
    }

    @Nested
    inner class GetElfWithHighestCalories {
        @Test
        fun `Given no elves return null`() {
            val input: List<Elf> = emptyList();
            val result = subject.getElfWithHighestCalories(input)
            assertNull(result);
        }

        @Test
        fun `Given one elf, return that elf`() {
            val elf = Elf(listOf(123))
            val input = listOf(elf)
            val result = subject.getElfWithHighestCalories(input)
            assertEquals(elf, result)
        }

        @Test
        fun `Given multiple elves, return elf with highest calories`() {
            val expectedElf = Elf(listOf(123))
            val input = listOf(Elf(listOf(1)), Elf(listOf(2)), expectedElf)
            val result = subject.getElfWithHighestCalories(input)
            assertEquals(expectedElf, result)
        }
    }
}