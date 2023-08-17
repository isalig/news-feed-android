package projects

import jetbrains.buildServer.configs.kotlin.project
import jetbrains.buildServer.configs.kotlin.toId

fun NewsFeedProject() = project {

    name = "News Feed Android"
    id(name.toId())

    vcsRoot {

    }

    subProjects(
        PullRequestProject(),
        MainProject()
    )
}
