package io.jimmyoak.service

import rx.Observable
import rx.lang.kotlin.toObservable
import java.math.BigInteger

object KotlinFibonacci {
    fun sequence(limit: Int): List<BigInteger> = (0..limit).map { fibonacciOn(it) }

    fun rxSequence(limit: Int): Observable<BigInteger> = (0..limit).toObservable().map { fibonacciOn(it) }

    private tailrec fun fibonacciOn(position: Int, previous: BigInteger = BigInteger.ZERO, next: BigInteger = BigInteger.ONE): BigInteger = when(position) {
        0 -> previous
        1 -> next
        else -> fibonacciOn(position - 1, next, next + previous)
    }
}