package com.slobevg.simplespin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SpinController(
    private val spinService: SpinService
) {

    @GetMapping("/api/symbols")
    fun symbols(): Spin {
        return spinService.symbols()
    }
}
