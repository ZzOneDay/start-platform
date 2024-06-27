package com.dmenu.dmenuadmin.mytest.domain.impl

import com.dmenu.dmenuadmin.mytest.domain.entity.MyTestEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MyTestServiceRepository : MongoRepository<MyTestEntity, String>