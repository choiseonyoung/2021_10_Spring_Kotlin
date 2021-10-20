package com.choiseonyoung.spring.controller

import com.choiseonyoung.spring.ConfigData
import com.choiseonyoung.spring.models.Buyer
import com.choiseonyoung.spring.service.BuyerService
import com.choiseonyoung.spring.service.impl.BuyerServiceImplV1
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    /**
     * lateinit var
     * 특별히 변수, 객체를 선언할 때 즉시 초기화하지 않고 나중에 초기화를 하겠다 라는 의미
     * 
     * Spring 환경에서는 Component(Service, Dao 등등) 객체는 코드에서 직접 초기화하지 않는다
     * 코드에서는 선언만 해두고 @Autowired 설정을 하면 Spring Ioc(*제어의 역전), DI(*Dependency Injection) 등의 기능에 의해 (나중에, 필요할 때) 자동으로 주입이 된다
     * 
     * 반드시 lateinit 키워드를 부착하여 선언해야 한다
     */
    @Autowired
    private lateinit var bService:BuyerService
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
    fun home(model: Model): String {

        println(ConfigData.APP_NAME)
        println(ConfigData.APP_VERSION)

//        val userList = bService.selectAll()
//        model.addAttribute("USERS",userList) *자바스러운 코드
//        model["USERS"] = userList

        return "redirect:/buyer/list"
        // * home으로 접속하면 buyer의 list로 전환시켜라
    }

    /**
     * @ResponseBody
     * 문자열, 객체, 배열 등등의 모든 데이터를 있는 그대로 또는 JSON 형태로 변환하여 client에 보내라
     */
    @ResponseBody
    @RequestMapping(value=["/list"],method=[RequestMethod.GET])
    fun list() : Array<Buyer> {

        return bService.selectAll()
    }


}

