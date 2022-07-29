package com.sessionsdev.lightningfastrecipes.controller

import com.sessionsdev.lightningfastrecipes.entity.business.RecipeDocument
import com.sessionsdev.lightningfastrecipes.entity.business.RecipePostRequest
import com.sessionsdev.lightningfastrecipes.repository.RecipeRepository
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/recipe")
class RecipeController (
    private val recipeRepository: RecipeRepository
        ) {
    @GetMapping
    fun getAllRecipes(): ResponseEntity<List<RecipeDocument>> {
        val recipes = recipeRepository.findAll()
        return ResponseEntity.ok(recipes)
    }

    @GetMapping("/{id}")
    fun getOneRecipe(@PathVariable("id") id: String):
            ResponseEntity<RecipeDocument> {
        val recipe = recipeRepository.findOneById(ObjectId(id))
        return ResponseEntity.ok(recipe)
    }

    @PostMapping
    fun createRecipe(@RequestBody request: RecipePostRequest): ResponseEntity<RecipeDocument> {
        val recipeDocument = recipeRepository.save(RecipeDocument(
            name = request.name
        ))

        return ResponseEntity(recipeDocument, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updatePatient(
        @RequestBody request: RecipePostRequest,
        @PathVariable("id") id: String
    ) : ResponseEntity<RecipeDocument> {
        val recipe = recipeRepository.findOneById(ObjectId(id))
        val updatedRecipeDocument = recipeRepository.save(RecipeDocument(
            id = recipe.id,
            name = request.name
        ))

        return ResponseEntity.ok(updatedRecipeDocument)
    }
}