import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
}


java {
	sourceCompatibility = JavaVersion.VERSION_17
}

allprojects {

	group = "com"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs += "-Xjsr305=strict"
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

subprojects {
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "kotlin")
	apply(plugin = "kotlin-kapt")

	tasks.register("prepareKotlinBuildScriptModel"){}		// Task 'prepareKotlinBuildScriptModel' not found in project 에러 해결 명령 전체 등록

	dependencies {
		//공통으로 사용할 종속성
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("io.github.oshai:kotlin-logging-jvm:6.0.3")	// kotlin logger

		testImplementation("io.kotest:kotest-assertions-core-jvm:5.8.0")	// kotest
		testImplementation("org.springframework.boot:spring-boot-starter-test")
	}
}

