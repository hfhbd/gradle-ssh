plugins {
    kotlin("jvm")
    id("setup")
}

kotlin {
    jvmToolchain(8)
    explicitApi()

    compilerOptions {
        progressiveMode.set(true)
    }
}

publishing.publications.register<MavenPublication>("mavenJava") {
    from(components["java"])
}

dependencies {
    api("com.hierynomus:sshj:0.39.0")

    implementation("net.java.dev.jna:jna:5.15.0")
    implementation("net.java.dev.jna:jna-platform:5.15.0")
}

licensee {
    allow("MIT")
    allowUrl("http://www.jcraft.com/jzlib/LICENSE.txt") {
        because("BSD")
    }
    allowUrl("https://www.bouncycastle.org/licence.html") {
        because("MIT")
    }
    allow("CC0-1.0")
}
