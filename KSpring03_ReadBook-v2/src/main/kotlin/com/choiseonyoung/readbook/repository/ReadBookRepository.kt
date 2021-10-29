package com.choiseonyoung.readbook.repository

import com.choiseonyoung.readbook.models.BookDTO
import com.choiseonyoung.readbook.models.ReadBookDTO
import org.springframework.data.jpa.repository.JpaRepository

interface ReadBookRepository:JpaRepository<ReadBookDTO,Long> {}
interface BookRepository:JpaRepository<BookDTO,Long> {}

