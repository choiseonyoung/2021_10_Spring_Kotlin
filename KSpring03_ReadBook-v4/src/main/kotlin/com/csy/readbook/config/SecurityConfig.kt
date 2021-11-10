//package com.csy.readbook.config

import com.csy.readbook.service.MemberLoginService
import org.springframework.boot.SpringBootConfiguration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@SpringBootConfiguration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/insert").authenticated()
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
        auth.userDetailsService(MemberLoginService())
                .passwordEncoder(CustomPasswordEncoder())
    }

    class CustomPasswordEncoder : PasswordEncoder {
        override fun encode(plan: CharSequence): String {
            return plan.toString()
        }

        // * 패스워드가 일치하냐 묻는건데 일단 일치한다고 해놓은 거
        override fun matches(plan: CharSequence?, crypt: String?): Boolean {
            return true
        }

    }
}