package org.cameek.spring_sandbox.bitfinex

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/bitfinex")
class BitfinexController(
    private val service: BitfinexService
) {

    @GetMapping("/last-month-data")
    fun lastMonthData(): Mono<List<CandleData>> = service.fetchLastMonthData()
}