package org.cameek.spring_sandbox.bitfinex

data class CandleData(
    val timestamp: Long,
    val open: Double,
    val close: Double,
    val high: Double,
    val low: Double,
    val volume: Double
)