package com.dmenu.dmenuadmin.testutil

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class TestFileLoaderConfiguration {

    @Bean
    fun testFileLoader(
        objectMapper: ObjectMapper
    ): TestFileLoader {
        return TestFileLoader(objectMapper)
    }
}