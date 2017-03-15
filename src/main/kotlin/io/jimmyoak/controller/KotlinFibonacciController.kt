package io.jimmyoak.controller

import hu.akarnokd.rxjava.interop.RxJavaInterop
import io.jimmyoak.service.KotlinFibonacci
import io.reactivex.Observable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger

@RestController
class KotlinFibonacciController {
    fun <T> rx.Observable<T>.toV2(): Observable<T> {
        return RxJavaInterop.toV2Observable(this)
    }

    @GetMapping("/stream/kotlin/fibonacci-sequence/{limit}")
    fun syncSequence(@PathVariable limit: Int): List<BigInteger> = KotlinFibonacci.sequence(limit)

    @GetMapping("/stream/rxkotlin/fibonacci-sequence/{limit}")
    fun rxkotlinSequence(@PathVariable limit: Int): Observable<BigInteger> = KotlinFibonacci.rxSequence(limit).toV2()
}