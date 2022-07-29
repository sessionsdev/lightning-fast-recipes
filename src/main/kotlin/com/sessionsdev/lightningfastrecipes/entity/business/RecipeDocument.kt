package com.sessionsdev.lightningfastrecipes.entity.business

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("lightning_recipes")
data class RecipeDocument (
    @Id
    val id: String = ObjectId.get().toString(),
    val name: String
        )