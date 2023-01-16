group = "CrossFoundation"

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.+"
    `java-library`
}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("Sources/CrossFoundationKotlin"))
        }
    }

    test {
        java {
            setSrcDirs(listOf("Tests/CrossFoundationKotlinTests"))
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    implementation("CrossFile:CrossFile")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

