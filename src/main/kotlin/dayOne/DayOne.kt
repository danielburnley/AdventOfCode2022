package dayOne

class DayOne {
    fun getInput(): List<String> {
        val resource = this::class.java.getResource("/inputs/01.txt")
        if (resource != null) {
            return resource.readText().split("\n");
        }
        return emptyList();
    }

    fun parseInput(input: List<String>): List<Elf> {
        if (input.isEmpty()) return emptyList();

        val elves: MutableList<Elf> = mutableListOf()
        var calories: MutableList<Int> = mutableListOf()

        input.forEach {
            when (it) {
                "" -> {
                    elves += Elf(calories)
                    calories = mutableListOf();
                }

                else -> {
                    calories += it.toInt()
                }
            }
        }

        elves += Elf(calories)
        return elves;
    }

    fun getElfWithHighestCalories(input: List<Elf>): Elf? {
        if (input.isEmpty()) return null;
        return input.maxBy { it.itemCalories.sum() };
    }

    fun getTopThreeElves(input: List<Elf>): List<Elf> {
        if (input.isEmpty()) return emptyList();
        return input.sortedByDescending { it.itemCalories.sum() }.take(3);
    }

    fun partOne(): Int {
        val input = getInput();
        val parsedInput = parseInput(input);
        val elf = getElfWithHighestCalories(parsedInput);
        if (elf != null) return elf.itemCalories.sum();
        return 0;
    }

    fun partTwo(): Int {
        val input = getInput();
        val parsedInput = parseInput(input);
        val elves = getTopThreeElves(parsedInput);
        return elves.sumOf { it.itemCalories.sum() }
    }
}