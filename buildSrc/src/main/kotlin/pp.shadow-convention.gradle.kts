plugins {
    id("pp.kotlin-common-conventions")
    id("com.gradleup.shadow")
}

tasks {
    shadowJar {
        archiveClassifier.set("")
        archiveFileName.set("PluginPortalForked.jar")
        destinationDirectory.set(file("$rootDir/out"))

        minimize()
        exclude("com/google/common/")
    }

    build {
        dependsOn(shadowJar)
    }

    jar {
        enabled = false
    }
}
