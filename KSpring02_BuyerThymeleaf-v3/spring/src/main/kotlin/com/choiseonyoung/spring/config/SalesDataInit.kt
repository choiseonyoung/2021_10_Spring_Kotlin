package com.choiseonyoung.spring.config

import com.choiseonyoung.spring.ConfigData
import com.choiseonyoung.spring.models.Sales
import com.choiseonyoung.spring.repository.SalesRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean
import java.text.SimpleDateFormat
import java.util.*

/**
 * Spring Boot 가 시작될 때 사용할 초기값, 설정 등을 수행하는 클래스
 * SalesRepository 를 생성자 주입 방식으로 Wirering 한다
 * 클래스의 생성자 method에 매개변술로 설정만 해두면 된다
 */
@SpringBootConfiguration
class SalesDataInit(val saleDao: SalesRepository) {

    val logger = LoggerFactory.getLogger(SalesDataInit::class.java)

    private val pnames = listOf(
        "Z플립", "아이폰13",
        "버즈프로", "에어팟프로",
        "갤럭시워치", "애플워치",
    )

    @Bean
    fun dataInit():CommandLineRunner {

        for(num in 1..100) {
            saleDataInit()
        }

        return CommandLineRunner {
            logger.debug("Sale 데이터 ㅇㄹ니ㅏㅓ")
        }
    }

    private fun saleDataInit() {
        val userid = String.format("B%03d", ConfigData.RND.nextInt(20) + 1)
        val pname = pnames[ConfigData.RND.nextInt(pnames.size)]

        val qty = ConfigData.RND.nextInt(10) + 10 * 10
        val price = ConfigData.RND.nextInt(100) + 100 * 1000

        val df = SimpleDateFormat("yyyy-MM-dd")
        val dt = SimpleDateFormat("hh:mm:ss")

        val toData = df.format(Date())
        val toTime = dt.format(Date())

        val sales = Sales(
            userid = userid,
            pname = pname,
            qty = qty,
            amt = price,
            total = qty * price,

            date = toData,
            time = toTime,
        )
        saleDao.save(sales)
    }
}