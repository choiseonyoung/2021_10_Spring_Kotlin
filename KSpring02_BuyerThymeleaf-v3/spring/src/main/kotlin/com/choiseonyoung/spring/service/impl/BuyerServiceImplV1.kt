package com.choiseonyoung.spring.service.impl

import com.choiseonyoung.spring.ConfigData
import com.choiseonyoung.spring.ConfigData.Companion.BUYER_LIST
import com.choiseonyoung.spring.models.Buyer
import com.choiseonyoung.spring.repository.BuyerRepository
import com.choiseonyoung.spring.service.BuyerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
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
        val findUser = ConfigData.BUYER_LIST.filter { buyer-> buyer.userid == userid }
        return findUser[0]
    }

    override fun findByName(name: String): Array<Buyer> {
        val userNum = ConfigData.RND.nextInt(BUYER_LIST.size)
        return arrayOf(ConfigData.BUYER_LIST[userNum])
    }

    override fun findByTel(name: String): Array<Buyer> {
        TODO("Not yet implemented")
    }

    override fun insert(buyer: Buyer): Buyer {
        // Insert Or Update
        return bDao.save(buyer)
    }

    override fun delete(userid: String): Buyer {
        TODO("Not yet implemented")
    }

    override fun update(buyer: Buyer): Buyer {
        TODO("Not yet implemented")
    }

}