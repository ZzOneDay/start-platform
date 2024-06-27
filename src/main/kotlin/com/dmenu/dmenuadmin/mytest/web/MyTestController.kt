package com.dmenu.dmenuadmin.mytest.web

import com.dmenu.dmenuadmin.mytest.domain.api.MyTestService
import com.dmenu.dmenuadmin.mytest.domain.dto.MyTestRequestDto
import com.dmenu.dmenuadmin.mytest.domain.dto.MyTestResponseDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MyTestController(
    private val myTest: MyTestService
) {

    @Operation(
        description = "I am test",
        method = "Post",
        tags = ["test"]
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Success",
                content = [
                    Content(
                        schema = Schema(
                            implementation = MyTestResponseDto::class
                        )
                    )
                ]
            )
        ]
    )
    @PostMapping("/me")
    fun me(@RequestBody requestDto: MyTestRequestDto): MyTestResponseDto {
        return myTest.me(requestDto)
    }
}