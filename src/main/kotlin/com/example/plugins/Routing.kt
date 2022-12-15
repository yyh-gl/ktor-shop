package com.example.plugins

import com.example.contoroller.contents.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val contentController by inject<ContentController>()

    routing {
        get("/") {
            val contents: ContentsView = contentController.list()
            call.respond(FreeMarkerContent("contents.ftl", mapOf("contents" to contents.values)))
        }
    }
}
