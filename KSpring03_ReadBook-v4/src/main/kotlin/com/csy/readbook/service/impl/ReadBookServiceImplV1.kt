package com.csy.readbook.Service.impl

import com.csy.readbook.Service.ReadBookService
import com.csy.readbook.models.BookDTO
import com.csy.readbook.models.ReadBookDTO
import com.csy.readbook.models.ReadBookVO
import com.csy.readbook.repository.BookRepository
import com.csy.readbook.repository.ReadBookRepository
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