plugins {
    id("java-library")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "blarknes"
version = "0.1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
    testCompileOnly("org.projectlombok:lombok:1.18.32")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.32")
}

application {
    mainClass.set("blarknes.codle.Codle")
}

javafx {
    version = "21.0.2"
    modules("javafx.controls", "javafx.fxml")
}
