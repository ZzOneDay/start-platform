package com.dmenu.dmenuadmin.testutil

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestcontainersConfiguration::class, TestFileLoaderConfiguration::class)
annotation class ApplicationTest
