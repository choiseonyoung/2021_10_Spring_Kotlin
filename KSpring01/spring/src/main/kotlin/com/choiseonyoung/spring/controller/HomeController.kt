package com.choiseonyoung.spring.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    @ResponseBody
    @RequestMapping(value=["/"],method=[RequestMethod.GET])
    fun home() : String {
        return "짜증나"
    }

    @RequestMapping(value=["/hello"],method=[RequestMethod.GET])
    fun hello(model:Model) :String {
        model.addAttribute("name","최서녕이")
        return "hello"
    }
}