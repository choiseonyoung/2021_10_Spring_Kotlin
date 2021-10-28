package com.choiseonyoung.readbook.models

import javax.persistence.*

@Entity
@Table(name="tbl_readbook", schema="naraDB")
data class ReadBook(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    var seq : Long?=0,

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    var isbn : String?=null,

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    var rdate : String?=null,

    @Column(columnDefinition = "VARCHAR(8)", nullable = false)
    var stime : String?=null,

    @Column(columnDefinition = "VARCHAR(8)", nullable = false)
    var etime : String?=null,

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    var rating : String?=null,

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    var comment : String?=null
)
