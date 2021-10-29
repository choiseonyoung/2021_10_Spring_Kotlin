package com.choiseonyoung.readbook.Service.impl

import com.choiseonyoung.readbook.Service.ReadBookService
import com.choiseonyoung.readbook.models.BookDTO
import com.choiseonyoung.readbook.models.ReadBookDTO
import com.choiseonyoung.readbook.models.ReadBookVO
import com.choiseonyoung.readbook.repository.BookRepository
import com.choiseonyoung.readbook.repository.ReadBookRepository
import org.springframework.stereotype.Service

// * ReadBookService increment
@Service("readBookServiceV1")
class ReadBookServiceImplV1(val readBookDao:ReadBookRepository, val bookDao:BookRepository):ReadBookService {
    override fun readBookInsert(readBook: ReadBookVO) {
        val readBookDTO = ReadBookDTO(0, isbn=readBook.isbn, title=readBook.title, content=readBook.content)
        val bookDTO = BookDTO(isbn=readBook.isbn, title=readBook.title)
        readBookDao.save(readBookDTO)
        bookDao.save(bookDTO)
    }
}