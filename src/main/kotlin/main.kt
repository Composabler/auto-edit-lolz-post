import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import me.topilov.LolzApi
import java.io.File
import java.lang.Exception

val CONFIG = System.getenv("CONFIG")

fun main(args: Array<String>) = runBlocking {
    val configFile = File(CONFIG)
    val config = mapper.readValue(configFile, Config::class.java)
    val api = LolzApi(config.token)

    while (true) {
        try {
            val currentMedia = config.media.shuffled().take(10)
            val postBody = "${config.title}\n${currentMedia.joinToString("\n")}"

            api.forumApiService.editProfilePost(
                profilePostId = config.profilePostId,
                postBody = postBody,
            )

            println("post edited")

            delay(config.delay)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}