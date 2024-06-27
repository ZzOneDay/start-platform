package com.dmenu.dmenuadmin.mytest.domain.api

import com.dmenu.dmenuadmin.mytest.domain.dto.MyTestRequestDto
import com.dmenu.dmenuadmin.mytest.domain.dto.MyTestResponseDto

interface MyTestService {

    fun me(requestDto: MyTestRequestDto): MyTestResponseDto
}