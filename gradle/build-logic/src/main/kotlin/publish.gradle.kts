plugins {
    id("java-library")
    id("maven-publish")
    id("signing")
    id("io.github.hfhbd.mavencentral")
}

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications.withType<MavenPublication>().configureEach {
        pom {
            name.set("app.softwork Gradle SSH")
            description.set("A Gradle plugin to upload your files using SSH")
            url.set("https://github.com/hfhbd/gradle-ssh")
            licenses {
                license {
                    name.set("The Apache License, Version 2.0")
                    url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                }
            }
            developers {
                developer {
                    id.set("hfhbd")
                    name.set("Philip Wedemann")
                    email.set("mybztg+mavencentral@icloud.com")
                }
            }
            scm {
                connection.set("scm:git://github.com/hfhbd/gradle-ssh.git")
                developerConnection.set("scm:git://github.com/hfhbd/gradle-ssh.git")
                url.set("https://github.com/hfhbd/gradle-ssh")
            }
        }
    }
}

signing {
    val signingKey = providers.gradleProperty("signingKey")
    if (signingKey.isPresent) {
        useInMemoryPgpKeys(signingKey.get(), providers.gradleProperty("signingPassword").get())
        sign(publishing.publications)
    }
}

tasks.withType<AbstractArchiveTask>().configureEach {
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true
    filePermissions {}
    dirPermissions {}
}
