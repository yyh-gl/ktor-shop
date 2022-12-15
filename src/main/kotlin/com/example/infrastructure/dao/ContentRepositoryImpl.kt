package com.example.infrastructure.dao

import com.example.domain.entity.Content
import com.example.domain.repository.ContentRepository
import com.example.infrastructure.api.StripeClient

class ContentRepositoryImpl(
    private val stripeClient: StripeClient,
) : ContentRepository {
    override fun listAll(): List<Content> {

        val contents = stripeClient.listAllProducts()
        return contents.map {
            Content(
                id = it.id,
                name = it.name,
                price = it.price,
            )
        }
    }
}
