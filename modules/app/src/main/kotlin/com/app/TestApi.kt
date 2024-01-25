package com.app

import com.common.TestInterface
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {  }

@RestController
@RequestMapping("/app-test")
class TestApi: TestInterface {  // common 모듈의 인터페이스 상속

    @GetMapping("/app/{name}")
    override fun test(@PathVariable name: String?): String {
        logger.info { "Hello $name" }
        return "Hello $name!";
    }
}