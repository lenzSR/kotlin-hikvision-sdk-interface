plugins {
    kotlin("jvm") version "2.1.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // 日志
    implementation("ch.qos.logback:logback-classic:1.5.16")

    // 使用JNA加载海康dll
    implementation("net.java.dev.jna:jna:5.13.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("org.example.MainKt") // 注意：Main.kt 对应的 class 是 MainKt
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.example.MainKt"
    }

    // 把所有依赖一起打进 JAR（可选）
    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}