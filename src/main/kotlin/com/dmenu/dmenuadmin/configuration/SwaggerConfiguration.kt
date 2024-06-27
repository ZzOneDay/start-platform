package com.dmenu.dmenuadmin.configuration

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
class SwaggerConfiguration {
    private val swaggerUrl: String = "http://localhost:8080"

    @Bean
    @Order(1)
    fun filterChainOpenApi(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf {
                disable()
            }
            securityMatcher(
                AntPathRequestMatcher.antMatcher("/v3/api-docs/**"),
                AntPathRequestMatcher.antMatcher("/swagger-ui/**")
            )
            authorizeHttpRequests {
                authorize(anyRequest, permitAll)
            }
        }
        return http.build()
    }

    @Bean
    fun openAPI(): OpenAPI {
        val openAPI = OpenAPI()
        openAPI.servers = listOf(
            Server().url(swaggerUrl)
        )
        return openAPI
    }
}