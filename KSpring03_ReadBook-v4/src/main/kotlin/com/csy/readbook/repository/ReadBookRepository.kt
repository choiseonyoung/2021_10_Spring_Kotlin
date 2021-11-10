package com.csy.readbook.repository

import com.csy.readbook.models.BookDTO
import com.csy.readbook.models.ReadBookDTO
import org.springframework.data.jpa.repository.JpaRepository

interface ReadBookRepository:JpaRepository<ReadBookDTO,Long> {}
interface BookRepository:JpaRepository<BookDTO,Long> {}

