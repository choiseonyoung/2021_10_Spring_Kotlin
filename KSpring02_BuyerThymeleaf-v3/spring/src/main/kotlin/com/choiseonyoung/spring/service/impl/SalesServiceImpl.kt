package com.choiseonyoung.spring.service.impl

import com.choiseonyoung.spring.repository.BuyerRepository
import com.choiseonyoung.spring.repository.SalesRepository
import com.choiseonyoung.spring.service.BuyerService
import org.springframework.stereotype.Service

@Service("sServiceV1")
class SalesServiceImpl(val bRepo: SalesRepository): BuyerService {
}