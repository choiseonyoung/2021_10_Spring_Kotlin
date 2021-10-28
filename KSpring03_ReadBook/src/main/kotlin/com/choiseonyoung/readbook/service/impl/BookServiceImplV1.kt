package com.choiseonyoung.readbook.service.impl

import com.choiseonyoung.readbook.models.Book
import com.choiseonyoung.readbook.repository.BookRepository
import com.choiseonyoung.readbook.service.BookService
import org.springframework.stereotype.Service

@Service("bServiceV1")
class BookServiceImplV1(val bRepo:BookRepository):BookService {
    override fun insert(book: Book): Book {
        return bRepo.save(book);
    }
}