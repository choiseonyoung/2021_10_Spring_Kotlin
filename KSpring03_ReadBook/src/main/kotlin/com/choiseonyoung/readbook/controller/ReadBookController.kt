package com.choiseonyoung.readbook.controller

import com.choiseonyoung.readbook.models.Book
import com.choiseonyoung.readbook.models.ReadBook
import com.choiseonyoung.readbook.service.BookService
import com.choiseonyoung.readbook.service.ReadBookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value=["/read"])
class ReadBookController(val bService: BookService, val rService: ReadBookService) {

    @RequestMapping(value=["/insert"],method=[RequestMethod.GET])
    fun insert(model: Model) : String {
        return "write"
    }

    @ResponseBody
    @RequestMapping(value=["/insert"],method=[RequestMethod.POST])
    fun insert(book:Book, read:ReadBook) : String {
//        read.seq = "1"
        bService.insert(book)
        rService.insert(read)
        return "redirect:/"
    }
}