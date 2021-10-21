package com.choiseonyoung.spring.service.impl

import com.choiseonyoung.spring.ConfigData
import com.choiseonyoung.spring.ConfigData.Companion.BUYER_LIST
import com.choiseonyoung.spring.models.Buyer
import com.choiseonyoung.spring.repository.BuyerRepository
import com.choiseonyoung.spring.service.BuyerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.random.Random


/**
 * 클래스의 매개변수를 사용하여 생성자 주입하기
 * class 클래스( 주입받을객체, 변수 선언 )
 *
 */
// * 1개만 있으면 상관없긴 하지만 버전이 여러개일 경우를 ~
@Service("bServiceV1")
class BuyerServiceImplV1(val bRepo: BuyerRepository):BuyerService {

    // setter 주입으로 와이어링 하기
    @Autowired
    private lateinit var bDao : BuyerRepository

    // 현재 BuyerServiceImplV1 에서 사용할 가상 데이터를
    // 선언하기
    // private : 여기 클래스 내부에서만 사용하는 static 변수 선언하기
//    companion object {
//
//    }


    override fun selectAll(): Array<Buyer> {
        return bRepo.findAll().toTypedArray()
    }

    override fun findById(userid: String): Buyer {

        // repository의 findById()는
        // 실제 데이터(Buyer)를 Optional 이라는 특별한 객체로 wrapping하여 가져온다
        // 필요한 데이터는 .get() method를 사용하여 한번 더 추출해줘야 한다
        val buyer:Optional<Buyer> = bRepo.findById(userid)
        return buyer.get()
    }

    override fun findByName(name: String): Array<Buyer> {
        val buyers = bRepo.findByName(name)
        return buyers
    }

    override fun findByTel(name: String): Array<Buyer> {
        TODO("Not yet implemented")
    }

    override fun insert(buyer: Buyer): Buyer {
        // Insert Or Update
        return bDao.save(buyer)
    }

    override fun delete(userid: String) {
        bRepo.deleteById(userid);
    }

    override fun update(buyer: Buyer): Buyer {
        return bDao.save(buyer)
    }

}