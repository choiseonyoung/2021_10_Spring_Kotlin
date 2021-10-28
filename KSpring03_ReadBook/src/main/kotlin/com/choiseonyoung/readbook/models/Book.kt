package com.choiseonyoung.readbook.models

import javax.persistence.*

@Entity
@Table(name="tbl_book", schema="naraDB")
data class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    var isbn : Long?=0,

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    var title : String?=null,

    @Column(columnDefinition = "VARCHAR(20)")
    var comp : String?=null,

    @Column(columnDefinition = "VARCHAR(10)")
    var author : String?=null,

    @Column(columnDefinition = "Int(10)")
    var price : Int?=null

)
