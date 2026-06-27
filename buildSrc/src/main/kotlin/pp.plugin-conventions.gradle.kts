plugins {
    id("pp.kotlin-common-conventions")
    id("pp.shadow-convention")
}

repositories {
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

val libs = extensions.getByType(VersionCatalogsExtension::class.java).named("libs")

dependencies {
    implementation(project(":common"))

    compileOnly(libs.findLibrary("spigot-api").get())
}

tasks {
    processResources {
        val channel: String? = project.findProperty("channel") as? String
        
        val version = project.version as String;
        
        // Add channel suffix if specified
        val fullVersion = if (channel != null && channel != "stable") {
            "$version-$channel"
        } else {
            version
        }

        filesMatching(listOf("plugin.yml")) {
            expand("version" to fullVersion)
            println("Set plugin.yml version to $fullVersion")
        }

        outputs.upToDateWhen { false } // It caches the version number in the bulit resource, stopping the dynamic version replacement from working
    }
}
