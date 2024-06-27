package com.dmenu.dmenuadmin

import com.dmenu.dmenuadmin.testutil.TestcontainersConfiguration
import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<DmenuAdminApplication>().with(TestcontainersConfiguration::class).run(*args)
}
