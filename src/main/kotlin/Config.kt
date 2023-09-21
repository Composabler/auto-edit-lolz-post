import com.fasterxml.jackson.annotation.JsonProperty

data class Config(
    @JsonProperty("token") val token: String,
    @JsonProperty("profilePostId") val profilePostId: Int,
    @JsonProperty("title") val title: String,
    @JsonProperty("media") val media: List<String>,
    @JsonProperty("delay") val delay: Long,
)
