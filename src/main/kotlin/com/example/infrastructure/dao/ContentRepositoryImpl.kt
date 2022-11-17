package com.example.infrastructure.dao

import com.example.domain.repository.ContentRepository
import com.example.domain.entity.Content

class ContentRepositoryImpl: ContentRepository {
    override fun listAll(): List<Content> {
        return listOf(
            Content(1, "赤ペン", 100),
            Content(2, "青ペン", 200),
            Content(3, "黄ペン", 300),
        )
    }
}
