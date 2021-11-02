package com.csy.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Controller 를 만들지 않고 MVC 패턴의 가상의 Request 를 처리하는 클래스
 */
@SpringBootConfiguration
class WebMVCReqController:WebMvcConfigurer {
    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/member/view").setViewName("member/view")
//        * /member/mypage 로 요청이 들어오면 member 폴더에 mypage를 보여줘라
    }
}