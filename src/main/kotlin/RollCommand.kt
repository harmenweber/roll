import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.convert
import com.github.ajalt.clikt.parameters.arguments.multiple
import com.github.ajalt.mordant.terminal.Terminal

class RollCommand :
    CliktCommand(help = "Rolls dice as per your arguments: d6, 1d8, 2d10, 3d20, and so on.") {
    private val dice: List<Dice> by argument(
        name = "dice",
        help = "The dice to roll (e.g. d6, 1d8, 2d10, 3d20)"
    ).convert { Dice.parse(it) }.multiple(required = true)

    override fun run() {
        print(roll())
    }

    private fun roll(): List<Int> {
        return this.dice.flatMap { it.roll() }
    }

    private fun print(values: List<Int>) {
        val terminal = Terminal()
        values.forEach(terminal::println)
        if (values.size > 1) {
            values.sum().also { terminal.muted(message = "Sum: $it", stderr = true) }
        }
    }
}