import com.github.ajalt.clikt.core.BadParameterValue
import java.util.stream.IntStream
import kotlin.random.Random
import kotlin.streams.toList

data class Dice(val count: Int, val sides: Int) {

    fun roll(): List<Int> {
        return IntStream.range(0, count)
            .map { Random.nextInt(sides) + 1 }
            .toList()
    }

    companion object {

        private val DICE_PATTERN = Regex(pattern = "(\\d*)d(\\d+)")

        fun parse(string: String): Dice {
            val matchResult = DICE_PATTERN.matchEntire(string)
            if (matchResult != null) {
                val countString = matchResult.groupValues[1]
                return Dice(
                    if (countString.isNotEmpty()) countString.toInt() else 1,
                    matchResult.groupValues[2].toInt()
                )
            } else {
                throw BadParameterValue("$string does not meet the dice notation.")
            }
        }
    }
}
