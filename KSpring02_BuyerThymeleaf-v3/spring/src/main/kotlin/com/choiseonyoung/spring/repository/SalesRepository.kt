package com.choiseonyoung.spring.repository

import com.choiseonyoung.spring.models.Buyer
import com.choiseonyoung.spring.models.Sales
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SalesRepository: JpaRepository<Sales, String> {

}