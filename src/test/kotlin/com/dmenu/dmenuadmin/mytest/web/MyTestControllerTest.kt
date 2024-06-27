package com.dmenu.dmenuadmin.mytest.web

import com.dmenu.dmenuadmin.mytest.domain.dto.MyTestResponseDto
import com.dmenu.dmenuadmin.testutil.ApplicationTest
import com.dmenu.dmenuadmin.testutil.TestFileLoader
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ApplicationTest
class MyTestControllerTest{

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var testFileLoader: TestFileLoader

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    val filePrefix: String = this::class.java.simpleName

    @Test
    fun shouldReturnHelloMessageTest() {
        val requestDto = testFileLoader.loadFileFromResourcesAsString(
            "$filePrefix/request.json"
        )

        val response = mockMvc.perform(
            MockMvcRequestBuilders.post("/me")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestDto)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn().response.contentAsString
        val actualResponseDto = testFileLoader.loadFileFromResources<MyTestResponseDto>(
            "$filePrefix/response.json"
        )

        val expectedResponseDto = objectMapper.readValue(response, MyTestResponseDto::class.java)
        Assertions.assertEquals(expectedResponseDto, actualResponseDto)
    }
}