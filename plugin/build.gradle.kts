plugins {
    id("pp.plugin-conventions")
    id("io.papermc.hangar-publish-plugin")
    id("com.modrinth.minotaur")
}

repositories {
    maven("https://repo.flyte.gg/releases")
    maven("https://jitpack.io")
}

dependencies {   
    implementation("com.github.HangarMC:HangarJarScanner:906710dc36")

    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("dev.masecla:Modrinth4J:2.0.0")
    
    implementation("org.java-websocket:Java-WebSocket:1.5.7")
}