package com.csy.readbook.service

import com.csy.readbook.model.MemberVO
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MemberLoginService : UserDetailsService {

    private val userList = listOf(
            MemberVO(username = "callor", password = "1234"),
            MemberVO(username = "csy", password = "1234"),
            MemberVO(username = "sy", password = "1234"),
    )

    override fun loadUserByUsername(username: String): UserDetails {
        val member:MemberVO? = userList.find{ it.username == username }
        member ?: throw UsernameNotFoundException("사용자 ID가 잘못되었습니다")

        return member

    }
}