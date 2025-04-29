package org.cameek.spring_sandbox.bitfinex
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

data class CandleData(
    val timestamp: Long,               // raw Bitfinex epoch-ms
    val dateTimeUtc: LocalDateTime,    // human-readable UTC
    val open: Double,
    val close: Double,
    val high: Double,
    val low: Double,
    val volume: Double,
    val midPrice: Double               // OHLC average
) {
    companion object {
        fun fromRaw(arr: Array<Number>): CandleData {
            val srcTimestamp = arr[0].toLong()
            val srcOpen      = arr[1].toDouble()
            val srcClose     = arr[2].toDouble()
            val srcHigh      = arr[3].toDouble()
            val srcLow       = arr[4].toDouble()
            val srcVolume    = arr[5].toDouble()

            return CandleData(
                timestamp   = srcTimestamp,
                dateTimeUtc = Instant.ofEpochMilli(srcTimestamp)
                    .atZone(ZoneOffset.UTC)
                    .toLocalDateTime(),
                open        = srcOpen,
                close       = srcClose,
                high        = srcHigh,
                low         = srcLow,
                volume      = srcVolume,
                midPrice    = (srcOpen + srcHigh + srcLow + srcClose) / 4.0
            )
        }
    }
}