package com.example.plugins

import com.example.contoroller.contents.Content
import com.example.contoroller.contents.ContentController
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    routing {
        get("/") {
            val contentController = ContentController()
            val contents: List<Content> = contentController.list()
            call.respond(FreeMarkerContent("contents.ftl", mapOf("contents" to contents)))
        }
    }
}
