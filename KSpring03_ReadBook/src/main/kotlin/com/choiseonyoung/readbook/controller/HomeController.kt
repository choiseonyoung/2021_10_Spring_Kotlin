package com.choiseonyoung.readbook.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    @ResponseBody
    @RequestMapping(value=["","/"],method=[RequestMethod.GET])
    fun home() : String {
        return "방가방가"
    }
}