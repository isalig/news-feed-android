package projects

import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.toId

class PullRequestProject: Project({

    name = "Pull request"
    id(name.toId())
})
