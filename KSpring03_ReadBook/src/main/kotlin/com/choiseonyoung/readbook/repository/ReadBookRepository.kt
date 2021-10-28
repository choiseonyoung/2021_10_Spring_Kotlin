package com.choiseonyoung.readbook.repository

import com.choiseonyoung.readbook.models.Book
import com.choiseonyoung.readbook.models.ReadBook
import org.springframework.data.jpa.repository.JpaRepository

interface ReadBookRepository:JpaRepository<ReadBook, String> {
}