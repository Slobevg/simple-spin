package com.slobevg.simplespin

class Spin(val symbols: List<Int>) {
    private val line1 = listOf(1, 4, 7)
    private val table = mapOf(1 to 6, 2 to 10, 3 to 30)

    val result = result(symbols)

    fun result(symbols: List<Int>): Int? {
        val symbol = line1.map { symbols[it] }
                .distinct()
                .takeIf { it.size == 1 }
                .orEmpty()
                .firstOrNull()
        return table.getOrDefault(symbol, 0)
    }
}