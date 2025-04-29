package org.cameek.spring_sandbox.bitfinex

import org.springframework.http.ContentDisposition
//import org.springframework.http.server.ServerHttpResponse
import org.springframework.http.server.reactive.ServerHttpResponse
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

    @GetMapping(
        "/last-month-data.csv",
        produces = ["text/csv"]                // let callers ask for CSV explicitly
    )
    fun lastMonthDataCsv(response: ServerHttpResponse): Mono<String> {
        // optional: make browser download instead of displaying raw text
        response.headers.contentDisposition =
            ContentDisposition.attachment().filename("last-month-data.csv").build()

        return service.fetchLastMonthData()
            .map { CandleCsvFormatter.toCsv(it) }  // or it.toCsvManual()
    }
}