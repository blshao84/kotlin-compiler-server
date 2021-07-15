val kotlinVersion: String by System.getProperties()
val kotlinIdeVersion: String by System.getProperties()
val indexes: String by System.getProperties()
val indexesJs: String by System.getProperties()

plugins {
    kotlin("jvm")
    application
}

dependencies {
    implementation(project(":common", configuration = "default"))
    implementation("org.jetbrains.kotlin:kotlin-compiler-for-ide:$kotlinIdeVersion")
}

application {
    mainClass.set("indexation.MainKt")
    applicationDefaultJvmArgs = listOf("-Xmx8g")
}

tasks.withType<JavaExec> {
    val rootName = project.rootProject.projectDir.toString()
    args = listOf("$rootName${File.separator}$kotlinVersion", "$rootName${File.separator}$indexes", "$rootName${File.separator}$indexesJs")
}
