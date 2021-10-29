package com.choiseonyoung.readbook.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class ReadBookController {

    @RequestMapping(value=["/",""], method=[RequestMethod.GET])
    fun home() : String {
        return "redirect:/insert"
    }

    @RequestMapping(value=["/insert"],method=[RequestMethod.GET])
    fun insert() : String {
        return "readbook/write.html"
    }
}