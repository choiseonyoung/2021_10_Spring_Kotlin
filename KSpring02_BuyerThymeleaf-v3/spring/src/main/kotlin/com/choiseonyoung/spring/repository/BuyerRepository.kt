package com.choiseonyoung.spring.repository

import com.choiseonyoung.spring.models.Buyer
import org.springframework.data.jpa.repository.JpaRepository

interface BuyerRepository: JpaRepository<Buyer, String> {

}