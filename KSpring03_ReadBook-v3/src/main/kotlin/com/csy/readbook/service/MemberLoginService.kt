package com.csy.readbook.service

import com.csy.readbook.models.MemberVO
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Security Login Service 클래스
 * ( 보통 *.UserDetailService 라는 이름으로 구현한다 )
 *
 * Security Login Service 는 UserDetailsService 를 상속 받는다
 */
@Service
class MemberLoginService : UserDetailsService {

    // 가상의 member list 생성해두기
    private val userList = listOf(
            MemberVO(username = "callor", password = "1234"),
            MemberVO(username = "csy", password = "1234"),
            MemberVO(username = "sy", password = "1234"),
    )

    // findByUserName(username) : UserDetails
    override fun loadUserByUsername(username: String): UserDetails {
        // 배열.find {} : 배열의 요소 중 원하는 값이 담겨 있는가?
        // 담겨 있으면 해당 값을 return 하고, 없으면 null return
        val member:MemberVO? = userList.find{ it.username == username }
        // * username이 userList에 포함돼있냐?
        member ?: throw UsernameNotFoundException("사용자 ID가 잘못되었습니다")
        // * member가 null 값이면 자동으로 exception 발생할 것
        // * 스프링 시큐리티가 try catch 로 catch 해서 그 순간에 다른 거 다 제껴버리고 바로 redirect 화면으로 message 전달함
        
        return member

    }
}