package org.cameek.spring_sandbox.bitfinex

object CandleCsvFormatter {

    private const val HEADER =
        "timestamp,dateTimeUtc,open,close,high,low,volume,midPrice"

    fun toCsv(rows: List<CandleData>): String = buildString(capacity = rows.size * 80) {
        appendLine(HEADER)
        for (c in rows) {
            appendLine(
                "${c.timestamp}," +
                        "${c.dateTimeUtc}," +           // ISO-8601 “2025-04-29T17:45”
                        "${c.open}," +
                        "${c.close}," +
                        "${c.high}," +
                        "${c.low}," +
                        "${c.volume}," +
                        "${c.midPrice}"
            )
        }
    }
}