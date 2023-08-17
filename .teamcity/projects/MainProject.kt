package projects

import builds.AssembleDebugBuild
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.toId


class MainProject : Project({

    name = "Main"
    id(name.toId())

    buildType(AssembleDebugBuild())
})
