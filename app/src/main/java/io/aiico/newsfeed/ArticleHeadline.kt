package io.aiico.newsfeed

import kotlinx.serialization.Serializable

@Serializable
data class ArticleHeadline(
  val title: String,
  val synopsis: String,
)
