package com.dmenu.dmenuadmin.mytest.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "test_collection")
@TypeAlias("test_entity")
data class MyTestEntity(
    @Id
    val id: String,
    val value: String
)