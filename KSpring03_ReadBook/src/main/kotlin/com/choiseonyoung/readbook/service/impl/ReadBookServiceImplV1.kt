package com.choiseonyoung.readbook.service.impl

import com.choiseonyoung.readbook.models.Book
import com.choiseonyoung.readbook.models.ReadBook
import com.choiseonyoung.readbook.repository.BookRepository
import com.choiseonyoung.readbook.repository.ReadBookRepository
import com.choiseonyoung.readbook.service.BookService
import com.choiseonyoung.readbook.service.ReadBookService
import org.springframework.stereotype.Service

@Service("rServiceV1")
class ReadBookServiceImplV1(val rRepo: ReadBookRepository): ReadBookService {
    override fun insert(read: ReadBook): ReadBook {
        return rRepo.save(read);
    }
}