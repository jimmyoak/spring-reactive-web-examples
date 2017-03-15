# How to Spring reactive WebFlux

## Description

Just some small examples of how to Spring Reactive with RxJava, RxJava2 and Reactor

## How to

```bash
./gradlew build bootRun
```

Server sets up on [http://localhost:8080](http://localhost:8080)

## Endpoints

**IMPORTANT**: Add header `Accept: text/event-stream` for the event-stream responses

#### RxJava
[http://localhost:8080/stream/rxjava/fibonacci-sequence/3000](http://localhost:8080/stream/rxjava/fibonacci-sequence/3000)

#### RxJava2
[http://localhost:8080/stream/rxjava2/fibonacci-sequence/3000](http://localhost:8080/stream/rxjava2/fibonacci-sequence/3000)

#### Reactor
[http://localhost:8080/stream/reactor/fibonacci-sequence/3000](http://localhost:8080/stream/reactor/fibonacci-sequence/3000)

#### Future
[http://localhost:8080/stream/future/fibonacci-sequence/3000](http://localhost:8080/stream/future/fibonacci-sequence/3000)

#### Kotlin
[http://localhost:8080/stream/kotlin/fibonacci-sequence/3000](http://localhost:8080/stream/kotlin/fibonacci-sequence/3000)

#### RxKotlin
[http://localhost:8080/stream/rxkotlin/fibonacci-sequence/3000](http://localhost:8080/stream/rxkotlin/fibonacci-sequence/3000)