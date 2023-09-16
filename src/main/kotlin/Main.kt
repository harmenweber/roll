import com.sksamuel.hoplite.ConfigLoaderBuilder
import com.sksamuel.hoplite.addResourceSource

fun main(args: Array<String>) {
    RollCommand(loadConfig()).main(args)
}

private fun loadConfig() = ConfigLoaderBuilder.default()
    .addResourceSource("/config.yml")
    .build()
    .loadConfigOrThrow<Config>()