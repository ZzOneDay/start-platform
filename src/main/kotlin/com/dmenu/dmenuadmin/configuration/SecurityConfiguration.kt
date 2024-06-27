package com.dmenu.dmenuadmin.configuration

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration(exclude = [UserDetailsServiceAutoConfiguration::class])
class SecurityConfiguration {

    @Bean
    @Order(2)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf {
                disable()
            }
            authorizeHttpRequests {
                authorize(AntPathRequestMatcher.antMatcher("/me"), permitAll)
                authorize(anyRequest, authenticated)
            }
        }
        return http.build()
    }
}