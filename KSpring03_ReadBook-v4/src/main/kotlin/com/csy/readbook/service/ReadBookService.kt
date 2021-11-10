package com.csy.readbook.Service

import com.csy.readbook.models.ReadBookVO

interface ReadBookService {
    fun readBookInsert(readBook:ReadBookVO)
}