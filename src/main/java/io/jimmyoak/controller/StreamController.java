package io.jimmyoak.controller;

import io.jimmyoak.service.Fibonacci;
import hu.akarnokd.rxjava.interop.RxJavaInterop;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.Future;

@RestController
public class StreamController {
  @GetMapping("/stream/rxjava/fibonacci-sequence/{limit}")
  public io.reactivex.Observable<BigInteger> rxjavaStream(@PathVariable int limit) {
    return RxJavaInterop.toV2Observable(Fibonacci.rxSequence(limit).subscribeOn(rx.schedulers.Schedulers.computation()));
  }
  @GetMapping("/stream/rxjava2/fibonacci-sequence/{limit}")
  public io.reactivex.Observable<BigInteger> rxjava2Stream(@PathVariable int limit) {
    return Fibonacci.rx2Sequence(limit).subscribeOn(io.reactivex.schedulers.Schedulers.computation());
  }

  @GetMapping("/stream/reactor/fibonacci-sequence/{limit}")
  public reactor.core.publisher.Flux<BigInteger> reactorStream(@PathVariable int limit) {
    return Fibonacci.reactorSequence(limit).subscribeOn(reactor.core.scheduler.Schedulers.elastic());
  }

  @GetMapping("/stream/future/fibonacci-sequence/{limit}")
  public Future<List<BigInteger>> futureStream(@PathVariable int limit) {
    return Fibonacci.futureSequence(limit);
  }
}
