package com.choiseonyoung.spring.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    /**
     * Spring 일반 Controller에서
     * method가 문자열을 return하면
     * view 파일을 열어서 rendering하여 client로 보내라
     * 
     * RESTful API 방식이다
     * RestController 또는 method에 @ResponseBody가 부착되면
     * 문자열을 그대로 client로 보내라
     */
    
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun home(): String {
        return "home"
    }
}