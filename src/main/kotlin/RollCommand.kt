import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.mordant.terminal.Terminal

class RollCommand :
    CliktCommand(help = "Reads a Gherkin data table from stdin, transposes it and prints the result to stdout.") {

    override fun run() {
        Terminal().println("Hello World!")
    }
}