package com.csy.readbook.config

import com.csy.readbook.service.MemberLoginService
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

// 프로젝트 설정을 위한 클래스다
@SpringBootConfiguration
// 프로젝트에 Spring Security 설정을 추가한다
// Spring Security 를 Customizing 하겠다
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/static/**","/static/css/**","/static/js/**","/static/images/**", "*.ico", "*.txt")
        // * static 폴더에 들어있는 것들은 굳이 씨큐리티를 적용하지 않아도 되기 때문에 그걸 간섭하지말라고 설정
        // * /static/** 만 해도 되지만 좀 더 명확하게 하기 위해 다 써줬음

        web.ignoring()
                .requestMatchers(
                        PathRequest
                                .toStaticResources()
                                .atCommonLocations()
                )
    }

    /**
     * 인증 절차를 수행하는 policy 설정
     */
    override fun configure(http: HttpSecurity) {

        // client 로부터 전달된 Req 가 인가된 요청인가를 확인하겠다
//        http.authorizeRequests()
//                .antMatchers("/member/mypage")
//                .authenticated()
//        http.authorizeRequests()
//                .antMatchers("/**")
//                .permitAll() // * 모든 요청에 대해 / 통과시키겠다
//        아래처럼 연결해서 쓸 수 있다

        // antMatchers(), mvcMatcher() 등은 authorizeRequests() 함수와 chaining 관계에 있는 함수들이다
        // authorizeRequests() 함수 아래에 다수의 antMatchers() 를 계속해서 추가할 수 있다
        http.authorizeRequests()
                // member/mypage 로 req(요청)이 오면 인증 절차를 수행하라
                .antMatchers("/member/login").permitAll() // * 의미 없어짐

                .antMatchers("/member/mypage").authenticated()
                .antMatchers("/member/**").permitAll()
                // * mypage 는 인증을 하되 그 외는 다 통과시켜라. 윗줄과 윗윗줄 순서 바꾸면 안 된다

                .antMatchers("/**").permitAll()

        // 단독으로 사용되는 method 함수들은 http.함수() 형식으로 사용한다
        // http.httpBasic()
        // http.formLogin()

        //  단독으로 사용되는 method 함수들을 chaining 방식으로 사용할 때는 and() 함수로 연결해준다
        // .and().httpBasic() // popup 로그인
        // custom login 폼을 사용할 때는 .and() 로 연결하지 말 것
        http.formLogin() // 로그인 form 보이기
                // security 기본 form 화면을 보이는 대신, 내가 만든 MemberController 의 login 으로 redirect 하라
                // * 스프링에서 기본적으로 보여주는 form이 아닌 내가 만든 form을 열겠다 (페이지 여는 거 아니고 redirect 하는거임)
                .loginPage("/member/login").permitAll()
                // custom login form 의 action 과 같은 url 을 지정
                .loginProcessingUrl("/login")
                .successForwardUrl("/member/mypage")


//                .usernameParameter("userid")
//                .passwordParameter("pass")

        // logout 을 구현하겠다
        http.logout()
                // ${rootPath}/logout 으로 요청이 들어오면
                // logout 을 수행하라
                .logoutRequestMatcher(AntPathRequestMatcher("/logout"))

                // logout 이 정상적으로 수행되면
                // /member/mypage 로 redirect 를 수행하라
                .logoutSuccessUrl("/member/mypage")
        // * RequestPath 가 logout 으로 요청이 되면 logout을 수행하고 /(루트)로 점프하라
    }

    /**
     * "{noop}12341234
     * Spring Security 에서 제공하는 password 정책
     * 5.x 버전이상에서는 의무적으로 password 를 DB 에 저장하거나
     * 비교연산 등을 할 때 반드시 암호화를 하도록 강제하고 있다
     *
     * 아직 암호화를 구현하지 않은 상태에서 테스트를 하기 위해서
     * 임시로 암호화 되지 않은 비밀번호를 사용해서
     * 비밀번호 비교를 하겠다 라는 의미의 메시지지     */
    override fun configure(auth: AuthenticationManagerBuilder) {
//        auth.inMemoryAuthentication()
//                .withUser("csy")
//                .password("{noop}12341234")
//                .roles("USER","ADMIN")

        // security야 UserDetailService 인터페이스를 상속받은 MemberLoginService 클래스의 객체를 너에게 건네주니
        // 회원 정보 인증을 할 때 사용해라
        // MemberLoginService.loadUserByUserName() 함수를 실행하여 사용자 정보를 나에게 달라
        auth.userDetailsService(MemberLoginService())
                // * 로그인 시도하면 MemberLoginService에 전달됨
                // auto 에 담긴 사용자 정보에서 password 항목을 찾아서
                // CustomPasswordEncoder() 에게 보내서 비밀번호가 맞는지 검사하라
                .passwordEncoder(CustomPasswordEncoder())
        // * 이게 실행된 순간 스프링 시큐리티는 정상적인 사용자! 구나 하고 허용?함
    }
}

// * 이 코드는 임시로 만든 거기 때문에 굳이 이해하지 않아도 된다
class CustomPasswordEncoder : PasswordEncoder {
    override fun encode(plan: CharSequence): String {
        return plan.toString()
    }

    // * 패스워드가 일치하냐 묻는건데 일단 일치한다고 해놓은 거
    override fun matches(plan: CharSequence?, crypt: String?): Boolean {
        return true
    }

}