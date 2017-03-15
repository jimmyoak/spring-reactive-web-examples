package io.jimmyoak.service;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fibonacci {
  public static List<BigInteger> listSequence(int limit) {
    return IntStream.range(0, limit)
        .mapToObj(Fibonacci::fibonacciOn)
        .collect(Collectors.toList());
  }

  public static rx.Observable<BigInteger> rxSequence(int limit) {
    return rx.Observable.range(0, limit)
        .map(Fibonacci::fibonacciOn);
  }

  public static Observable<BigInteger> rx2Sequence(int limit) {
    return Observable.range(0, limit)
        .map(Fibonacci::fibonacciOn);
  }

  public static Flux<BigInteger> reactorSequence(int limit) {
    return Flux.range(0, limit)
        .map(Fibonacci::fibonacciOn);
  }

  public static Future<List<BigInteger>> futureSequence(int limit) {
    return CompletableFuture.supplyAsync(() ->
        IntStream.range(0, limit)
            .mapToObj(Fibonacci::fibonacciOn)
            .collect(Collectors.toList())
    );
  }

  public static Stream<BigInteger> streamSequence(int limit) {
    return IntStream.range(0, limit)
        .mapToObj(Fibonacci::fibonacciOn);
  }

  private static BigInteger fibonacciOn(int position) {
    return fibonacciOn(position, BigInteger.ZERO, BigInteger.ONE);
  }

  private static BigInteger fibonacciOn(int position, BigInteger previous, BigInteger next) {
    if (position == 0) {
      return previous;
    }

    if (position == 1) {
      return next;
    }

    return fibonacciOn(position - 1, next, next.add(previous));
  }
}
