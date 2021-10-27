package com.choiseonyoung.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@SpringBootConfiguration
// spring Security를 Custom 하겠다 선언
@EnableWebSecurity
class SecurityConfig:WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests().mvcMatchers("/**")
            .anonymous()
            .mvcMatchers("/admin/**")
            .fullyAuthenticated()
        // * 우리 서버로 누군가 리퀘스트를 보낼텐데 그 리퀘스트의 권한을 내가 관리하겠다
        // * HttpSecurity 로 넘어오는 요청을 가로채기 하겠다
        // (( /** : 모든 요청. 모든 리퀘스트에 대하여 ))
        // * anoymous() : 누구나
    }
}