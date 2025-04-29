package org.cameek.spring_sandbox.bitfinex

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class BitfinexService(
    private val webClient: WebClient = WebClient.builder()
        .baseUrl("https://api-pub.bitfinex.com")
        .build()
) {

    fun fetchLastMonthData(symbol: String = "tBTCUSD"): Mono<List<CandleData>> {
        val uri = "/v2/candles/trade:1D:$symbol/hist?limit=30&sort=1"

        return webClient.get()
            .uri(uri)
            .retrieve()
            .bodyToMono(Array<Array<Number>>::class.java)
            .map { raw -> raw.map { CandleData.fromRaw(it) } }
    }
}