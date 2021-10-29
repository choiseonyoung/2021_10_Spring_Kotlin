package com.choiseonyoung.readbook.Service

import com.choiseonyoung.readbook.models.ReadBookVO

interface ReadBookService {
    fun readBookInsert(readBook:ReadBookVO)
}