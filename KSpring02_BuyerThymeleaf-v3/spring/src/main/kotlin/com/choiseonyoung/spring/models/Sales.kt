package com.choiseonyoung.spring.models

import java.util.*
import javax.persistence.*

/**
 * Id 컬럼을 자동 증가 옵션으로 자동 생성하기
 * SEQUENCE, IDENTITY, TABLE, AUTO
 * SEQUENCE : Oracle Sequence
 * IDENTITY : Auto_increment 가 지원되는 DB
 * TABLE : Hibernate 가 자체적으로 SEQUENCE TABLE을 만들고 증가 값을 관리하도록 하기
 * AUTO : 사용하는 DBMS 특성에 따라 SEQ를 만들거나 AUTO_IN..를 생성하여 증가값을 관리
 *
 * AUTO 설정을 하면 DB 특성에 따라 자체적으로 관리를 하는데
 * 현재는 그렇지 않고 hibernate_sequence 테이블을 생성하여
 * JPA가 자체적으로 Seq를 생성하도록 만들어진다
 * auto_increment 가 없는 DB에서는 AUTO로 설정하는 거을 권장
 */
@Entity
@Table(name="tbl_sales", schema="naraDB")
data class Sales(

    @Id
    @Column(columnDefinition = "BIGINT")
    @GeneratedValue(strategy=GenerationType.AUTO)
    var seq : Long,
    var date : String,
    var time : String,
    var pname : String,
    var qty : Int,
    var amt : Int,
    var total : Int,
    
    // 데이터에 특별하게 Date(날짜, 시간형) 값을 사용하고 싶을 때
    // * 쌤 경험상 Date 형으로 컬럼 해놓으면 나중에 골치아픔..String으로 해놓는게 제일 편함

    @Temporal(TemporalType.DATE)
    var date1 : Date,

    @Temporal(TemporalType.TIME)
    var time1 : Date,

    @Temporal(TemporalType.TIMESTAMP)
    var date_time : Date
)
