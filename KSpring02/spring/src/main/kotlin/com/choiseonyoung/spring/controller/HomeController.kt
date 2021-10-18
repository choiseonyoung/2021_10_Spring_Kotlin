package com.choiseonyoung.spring.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun home(): String {
        return "home"
    }
}