//package com.csy.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@SpringBootConfiguration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/member/mypage").authenticated()
                .antMatchers("/member/**").permitAll()

        http.formLogin()
                .loginPage("/member/login").permitAll()
                .loginProcessingUrl("/login")
                .successForwardUrl("/member/mypage")

        http.logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/member/mypage")
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
    }
}