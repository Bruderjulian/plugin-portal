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