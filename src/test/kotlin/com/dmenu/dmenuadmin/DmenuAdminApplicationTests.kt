package com.dmenu.dmenuadmin

import com.dmenu.dmenuadmin.testutil.TestcontainersConfiguration
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class DmenuAdminApplicationTests {

    @Test
    fun contextLoads() {
    }

}
