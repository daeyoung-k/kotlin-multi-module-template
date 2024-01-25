import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

dependencies {
    implementation(project(":common"))      // common 모듈 상속

    implementation("org.springframework.boot:spring-boot-starter-web")  // app 모듈에서만 사용할 web 종속성
}

// main class 설정
springBoot{
    mainClass.set("com.app.AppApplication")
}