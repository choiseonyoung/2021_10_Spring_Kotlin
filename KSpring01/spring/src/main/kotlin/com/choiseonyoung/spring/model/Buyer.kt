package com.choiseonyoung.spring.model

/**
 * Kotlin에서 DTO(VO)용 클래스 만들기
 * 1. data class로 시작하기
 * 2. 멤버변수를 함수처럼 클래스( 매개변수 ) 와 같이 선언
 */
data class Buyer(var id:String, var name:String, var age:Int)
