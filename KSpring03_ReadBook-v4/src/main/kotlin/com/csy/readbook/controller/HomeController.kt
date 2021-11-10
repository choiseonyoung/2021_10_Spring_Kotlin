package com.csy.readbook.controller

import com.csy.readbook.Service.ReadBookService
import com.csy.readbook.models.ReadBookVO
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class HomeController(val readBookService: ReadBookService) {
    @RequestMapping(value=["/"],method=[RequestMethod.GET])
    fun home() : String {

        return "redirect:/member/mypage"
    }

    @RequestMapping(value=["/insert"],method=[RequestMethod.GET])
    fun insert() : String {
        return "readbook/write.html"
    }

    @RequestMapping(value=["/insert"],method=[RequestMethod.POST])
    fun insert(readBook: ReadBookVO) : String {

        readBookService.readBookInsert(readBook)

        return "redirect:/insert"
    }
}