package com.example.plugins

import com.example.contoroller.contents.ContentController
import com.example.domain.repository.ContentRepository
import com.example.infrastructure.api.StripeClient
import com.example.infrastructure.dao.ContentRepositoryImpl
import com.example.usecase.ListContentUseCase
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
    install(Koin) { modules(appModule) }
}

val appModule = module {
    single { StripeClient() }
    single { ContentRepositoryImpl(get()) as ContentRepository }
    single { ListContentUseCase(get()) }
    single { ContentController(get()) }
}
