package com.choiseonyoung.readbook.service

import com.choiseonyoung.readbook.models.ReadBook

interface ReadBookService {
    fun insert(read: ReadBook): ReadBook
}