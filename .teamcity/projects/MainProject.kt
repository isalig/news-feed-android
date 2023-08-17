package projects

import builds.AssembleDebugBuild
import jetbrains.buildServer.configs.kotlin.Project


class MainProject : Project({

    buildType(AssembleDebugBuild())
})
