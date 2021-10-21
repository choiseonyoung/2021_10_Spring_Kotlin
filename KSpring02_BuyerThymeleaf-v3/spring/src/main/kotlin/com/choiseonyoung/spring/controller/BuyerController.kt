package com.choiseonyoung.spring.controller

import com.choiseonyoung.spring.ConfigData
import com.choiseonyoung.spring.models.Buyer
import com.choiseonyoung.spring.service.BuyerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping(value=["/buyer"])
class BuyerController(val bService:BuyerService) {

    // @GetMapping(name="/list")
    @RequestMapping(value=["/list"],method=[RequestMethod.GET])
    fun list(model: Model):String {

        val buyerList = bService.selectAll()
        model["BUYERS"] = buyerList

        return "buyer/list"
    }

    // localhost:8080/buyer/detail
    @RequestMapping(value=["/detail"], method=[RequestMethod.GET])
    fun detail(model: Model, @RequestParam("userid") userid:String):String{

        val buyer = bService.findById(userid)
        model["BUYER"] = buyer
        return "buyer/detail" // detail.html 을 열어라
    }

    /**
     * ModelAndAttribute 속성, 기능
     * Controller에서 Model 객체를 담고 form 화면을 rendering 하면
     * 
     * 보통은 form의 value 속성에 일일이 데이터를 추가하여 작성을 한다
     * 
     * ModelAttr 을 사용하면
     * 각각 view Template의 고유 기능을 사용하여
     * id, name, value 값을 자동으로 채워넣는 기능을 만들 수 있다
     * 
     * thymeleaf template 을 사용할 때는
     * form tag의 model에 담긴 object를 지정해주고
     * 각 input box에 있는 field 속성으로 해당 멤버 변수(요소,속성)을 지정해주면
     * template 엔진이 rendering을 수행하면서 input box에 필요한 요소들을 적절하게 생성해준다
     */
//    @ResponseBody
    @RequestMapping(value=["/insert"],method=[RequestMethod.GET])
    fun insert(model:Model): String {
//        val insertBuyer = ConfigData.BUYER_LIST[0]
        model["BUYER"] = Buyer()
//        bService.insert(insertBuyer)
//
//        return insertBuyer
        return "buyer/write"
    }

    @RequestMapping(value=["/insert"],method=[RequestMethod.POST])
    fun insert(model:Model, buyer:Buyer):String {
        bService.insert(buyer)
        return "redirect:/buyer/list"
    }

    // localhost:8080/update/B001 URL로 요청을 하면
    // B001 값을 userid에 담아서 함수 내부로 전달된다
    @RequestMapping(value=["/update/{userid}"],method=[RequestMethod.GET])
    fun update(model:Model,@PathVariable("userid") userid:String):String {
        val buyer = bService.findById(userid)
        model["BUYER"] = buyer
        return "buyer/write"
    }




}