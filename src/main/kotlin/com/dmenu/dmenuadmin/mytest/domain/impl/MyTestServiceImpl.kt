package com.dmenu.dmenuadmin.mytest.domain.impl

import com.dmenu.dmenuadmin.mytest.domain.api.MyTestService
import com.dmenu.dmenuadmin.mytest.domain.dto.MyTestRequestDto
import com.dmenu.dmenuadmin.mytest.domain.dto.MyTestResponseDto
import com.dmenu.dmenuadmin.mytest.domain.mapping.MyTestMapping
import org.springframework.stereotype.Service

@Service
class MyTestServiceImpl(
    val myTestMapping: MyTestMapping,
    val myTestServiceRepository: MyTestServiceRepository,
    val mapping: MyTestMapping
): MyTestService {

    override fun me(requestDto: MyTestRequestDto): MyTestResponseDto {
        val myTestEntityInput = mapping.map("123", requestDto)
        myTestServiceRepository.save(myTestEntityInput)

        val findById = myTestServiceRepository.findById("123")
            .orElseThrow()
        return myTestMapping.map(findById)
    }
}