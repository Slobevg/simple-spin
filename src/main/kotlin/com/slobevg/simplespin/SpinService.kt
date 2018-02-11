package com.slobevg.simplespin

import org.springframework.stereotype.Service
import java.util.*

@Service
class SpinService(
    val random: Random = Random(),
    val drums: List<List<Int>> = listOf(
            listOf(1, 2, 3, 3)
            , listOf(1, 2, 2, 3)
            , listOf(1, 1, 2, 3)
    )
) {

    fun symbols() : Spin {
        return Spin(drums
                .map { list -> sector(list, rand(0, list.size)) }
                .flatten())
    }

    private fun sector(source: List<Int>, index: Int): List<Int> {
        return listOf(
                source.getOrElse(index - 1) { source[source.size - 1] }
                , source[index]
                , source.getOrElse(index + 1) { source[0] }
        )
    }

    private fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }

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
}