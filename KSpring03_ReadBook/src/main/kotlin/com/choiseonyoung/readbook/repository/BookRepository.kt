package com.choiseonyoung.readbook.repository

import com.choiseonyoung.readbook.models.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository:JpaRepository<Book, String> {
}