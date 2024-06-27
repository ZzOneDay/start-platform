package com.dmenu.dmenuadmin.testutil

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File

class TestFileLoader(
    val objectMapper: ObjectMapper
) {

    inline fun <reified T> loadFileFromResources(resourceFile: String): T {
        val fileUrl = TestFileLoader::class.java.getResource("/testdata/$resourceFile")?.toURI()
            ?: throw IllegalArgumentException("File not found: $resourceFile")
        val file = File(fileUrl)

        if (!file.exists() || !file.isFile) {
            throw IllegalArgumentException("File not found: $resourceFile")
        }

        return objectMapper.readValue(file, T::class.java)
    }

    fun loadFileFromResourcesAsString(resourceFile: String): String {
        val fileUrl = TestFileLoader::class.java.getResource("/testdata/$resourceFile")?.toURI()
            ?: throw IllegalArgumentException("File not found: $resourceFile")
        val file = File(fileUrl)

        if (!file.exists() || !file.isFile) {
            throw IllegalArgumentException("File not found: $resourceFile")
        }

        return file.readText()
    }
}