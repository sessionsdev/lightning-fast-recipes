package com.sessionsdev.lightningfastrecipes.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
class StatusController {
    @GetMapping("/status")
    fun getStatus(): String {
        return "Ok"
    }

}