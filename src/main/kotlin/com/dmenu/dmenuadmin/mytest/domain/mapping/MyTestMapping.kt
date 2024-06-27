package com.dmenu.dmenuadmin.mytest.domain.mapping

import com.dmenu.dmenuadmin.mytest.domain.dto.MyTestRequestDto
import com.dmenu.dmenuadmin.mytest.domain.dto.MyTestResponseDto
import com.dmenu.dmenuadmin.mytest.domain.entity.MyTestEntity
import org.springframework.stereotype.Component

@Component
class MyTestMapping {

    fun map(id: String, myTestDto: MyTestRequestDto): MyTestEntity {
        return MyTestEntity(id, myTestDto.value)
    }

    fun map(myTestEntity: MyTestEntity): MyTestResponseDto{
        return MyTestResponseDto(myTestEntity.value)
    }
}