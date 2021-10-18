package com.choiseonyoung.spring.service

import com.choiseonyoung.spring.model.Buyer

interface BuyerService {
    fun selectAll():Array<Buyer>
    // * Buyer 1개만 리턴할
    fun findById(id:String):Buyer
}