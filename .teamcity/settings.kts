import jetbrains.buildServer.configs.kotlin.project
import jetbrains.buildServer.configs.kotlin.version
import projects.MainProject
import projects.PullRequestProject

version = "2023.05"

project {

    subProjects(
        PullRequestProject(),
        MainProject()
    )
}
