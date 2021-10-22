package com.choiseonyoung.spring.controller

import com.choiseonyoung.spring.models.Sales
import com.choiseonyoung.spring.service.OrderService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping(value=["/order"])
class OrderController(val orService: OrderService) {

    // localhost:8080/order/ 또는
    // localhost:8080/order 요청을 모두 수용
    // * 최근 서버들이 이 두개를 구분하는 경우가 많아서 이 두개를 다 ~
    @RequestMapping(value=["","/"], method=[RequestMethod.GET])
    fun list(model: Model) : String {

        val salesList = orService.selectAll()
        model["SALES"] = salesList
        return "order/list"
    }

    @RequestMapping(value=["/detail"], method=[RequestMethod.GET])
    fun detail(model: Model, @RequestParam("seq") seq:Long):String {
        val sale = orService.findById(seq)
        model["SALE"] = sale
        return "order/detail"
    }
}