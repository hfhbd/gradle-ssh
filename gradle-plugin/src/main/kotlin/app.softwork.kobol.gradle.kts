import app.softwork.kobol.gradle.*

val uploadCobol by tasks.registering(UploadTask::class)
val buildCobol by tasks.registering(BuildTask::class) {
    dependsOn(uploadCobol)
}
tasks.register("runCobol", KobolRunTask::class) {
    dependsOn(buildCobol)
}

tasks.register("cleanCobol", CleanCobol::class) {
    uploaded.convention(uploadCobol.flatMap { it.uploaded })
}
