package com.choiseonyoung.spring.controller

import com.choiseonyoung.spring.models.Sales
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class OrderController {
    @RequestMapping(value=["/order"],method=[RequestMethod.GET])
    fun order() : Array<Sales> {

        return bService.selectAll()
    }
}