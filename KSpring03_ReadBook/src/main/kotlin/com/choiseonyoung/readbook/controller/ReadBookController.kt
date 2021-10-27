package com.choiseonyoung.readbook.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping(value=["/read"])
class ReadBookController {

    @RequestMapping(value=["/insert"],method=[RequestMethod.GET])
    fun insert() : String {
        return "write"
    }
}