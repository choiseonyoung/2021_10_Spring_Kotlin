package com.choiseonyoung.readbook.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="tbl_readbook", schema="naraDB")
data class ReadBook(

    @Id
    var seq : String?=null,
    var isbn : String?=null,
    var rdate : String?=null,
    var stime : String?=null,
    var etime : String?=null,
    var rating : String?=null,
    var comment : String?=null
)
