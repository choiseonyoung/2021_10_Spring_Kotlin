package com.choiseonyoung.readbook.service

import com.choiseonyoung.readbook.models.Book

interface BookService {
    fun insert(book: Book): Book
}