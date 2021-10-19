package com.choiseonyoung.spring.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

// * 여기에 테이블 구조를 만들겠다는 것
// * 내가 지금부터 엔티티를 선언할텐데 선언한 엔티티를 기준으로 이 테이블을 생성해라
@Entity
@Table(name="tbl_buyer", schema="naraDB")
class BuyerEntity {

    // * 너는 지금부터 primary key야 !
    @Id
    // * null 부분 -> 테이블 만들때 not null로 선언해라
    @Column(columnDefinition = "CHAR(4)", nullable=false)
    // * null 부분 -> 값이 아직 정해지지 않았기 때문에 잠시 null로 선언해놓겠다
    private val userid : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable=false)
    private val name : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable=false)
    private val tel : String? = null

    @Column(nullable=false)
    private val address : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable=false)
    private val manager : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable=false)
    private val man_tel : String? = null
    private val buy_total : Int = 0
}