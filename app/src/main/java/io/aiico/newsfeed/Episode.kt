package io.aiico.newsfeed

import kotlinx.serialization.Serializable

@Serializable
data class Response(
  val results: List<Episode>
)

@Serializable
data class Episode(
  val id: Int,
  val name: String,
  val episode: String,
  val url: String
)