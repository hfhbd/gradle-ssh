plugins {
    `kotlin-dsl`
    id("setup")
}

kotlin.jvmToolchain(21)

configurations.configureEach {
    if (isCanBeConsumed) {
        attributes {
            attribute(
                GradlePluginApiVersion.GRADLE_PLUGIN_API_VERSION_ATTRIBUTE,
                objects.named(GradleVersion.version("8.11").version)
            )
        }
    }
}

dependencies {
    compileOnly(projects.sshEnv)

    testImplementation(kotlin("test"))
}

tasks.validatePlugins {
    enableStricterValidation.set(true)
}

val storeVersion by tasks.registering(StoreVersion::class)
sourceSets.main {
    kotlin.srcDir(storeVersion)
}

gradlePlugin.plugins.configureEach {
    displayName = "Kobol Gradle Plugin"
    description = "Kobol Gradle Plugin"
}
