package com.sessionsdev.lightningfastrecipes.repository

import com.sessionsdev.lightningfastrecipes.entity.business.RecipeDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface RecipeRepository : MongoRepository<RecipeDocument, String> {
    fun findOneById(id: ObjectId): RecipeDocument
    override fun deleteAll()
}