package com.example.plugins

import com.example.contoroller.contents.*
import com.example.infrastructure.api.StripeClient
import com.example.infrastructure.dao.ContentRepositoryImpl
import com.example.usecase.ListContentUseCase
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            val stripeClient = StripeClient()
            val contentRepository = ContentRepositoryImpl(stripeClient)
            val listContentUseCase = ListContentUseCase(contentRepository)
            val contentController = ContentController(listContentUseCase = listContentUseCase)
            val contents: ContentsView = contentController.list()
            call.respond(FreeMarkerContent("contents.ftl", mapOf("contents" to contents.values)))
        }
    }
}
