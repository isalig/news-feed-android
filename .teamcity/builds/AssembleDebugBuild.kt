package builds

import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.DslContext
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildFeatures.swabra
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.toId
import jetbrains.buildServer.configs.kotlin.triggers.vcs

class AssembleDebugBuild : BuildType({
    name = "AssembleDebug"
    id(name.toId())

    steps {
        gradle {
            tasks = "clean :app:buildDebug"
        }
    }

    triggers {
        vcs {
        }
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    features {
        perfmon {

        }

        swabra {
            forceCleanCheckout = true
            verbose = true
        }
    }
})
