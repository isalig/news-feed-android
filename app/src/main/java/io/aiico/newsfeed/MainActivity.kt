package io.aiico.newsfeed

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.aiico.newsfeed.ui.theme.MyApplicationTheme
import io.aiico.newsfeed.ui.theme.Typography

val headlines = listOf(
  ArticleHeadline(
    title = "Everything you need to know",
    synopsis = "Everything You Need To Know About Boosting Your Productivity",
  ),
  ArticleHeadline(
    title = "Comparison headlines",
    synopsis = "Walking Versus Running : The Surprising Benefits of Taking It Slow",
  ),
  ArticleHeadline(
    title = "Top + number(e.g., Top 10) listing posts",
    synopsis = "The Top 7 Strategies for Landing Your Dream Job",
  ),
  ArticleHeadline(
    title = "A guide to…",
    synopsis = "A Guide to Prioritizing Your Mental Health: Why Self-Care Isn't Selfish",
  ),
  ArticleHeadline(
    title = "How-to",
    synopsis = "How To Save Money Like a Pro: Tips from Financial Experts",
  ),
  ArticleHeadline(
    title = "Mistakes to avoid",
    synopsis = "10 Mistakes To Avoid if You Want To Be a Social Media Boss",
  ),
  ArticleHeadline(
    title = "No one will tell you that…",
    synopsis = "What They Don’t Tell You About Setting Boundaries at Work",
  ),
  ArticleHeadline(
    title = "Increase your x with y",
    synopsis = "Increase Your Profitability with These Simple Efficiency Tricks",
  ),
  ArticleHeadline(
    title = "Stop doing this…",
    synopsis = "Why You Should Stop Worrying About Being Perfect",
  ),
  ArticleHeadline(
    title = "Listicles",
    synopsis = "10 Delicious Recipes You Can Make in Under 30 Minutes",
  ),
)

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          Feed(
            headlines,
            onClick = {
              Toast.makeText(this, "Article clicked", Toast.LENGTH_SHORT).show()
            }
          )
        }
      }
    }
  }
}

@Composable
fun Feed(headlines: List<ArticleHeadline>, onClick: () -> Unit = {}) {
  LazyColumn {
    items(headlines.size) { index ->
      FeedItem(headlines[index], onClick)
      HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
    }
  }
}

@Composable
fun FeedItem(headline: ArticleHeadline, onClick: () -> Unit = {}) {
  Column(
    modifier = Modifier
      .clickable { onClick() }
      .padding(16.dp)
  ) {
    Text(
      text = headline.title,
      style = Typography.titleLarge,
      modifier = Modifier
        .padding(bottom = 8.dp)
        .fillMaxWidth()
    )
    Text(
      text = headline.synopsis,
      style = Typography.bodyLarge,
      modifier = Modifier.fillMaxWidth(),
    )
  }
}

@Preview(showBackground = true)
@Composable
fun FeedPreview() {
  MyApplicationTheme {
    Feed(headlines)
  }
}
