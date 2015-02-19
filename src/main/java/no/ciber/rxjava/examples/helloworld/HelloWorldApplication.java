package no.ciber.rxjava.examples.helloworld;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class HelloWorldApplication {

    public static void main(String[] args) {

        Observable.create((Subscriber<? super String> subscriber) -> {
            subscriber.onNext("Hello");
            subscriber.onNext("World!");
            subscriber.onCompleted();
        }).subscribe(System.out::println);

        Arrays.asList("Per", "Pål", "Espen").stream()
                    .map(s -> "Hello " + s + "!")
                    .forEach(System.out::println);

        Observable
                .just("Per", "Pål", "Espen")
                .map(s -> "Morn " + s + "!")
                .subscribe(
                        /*onNext*/           System.out::println,
                        /*onError */         System.out::println,
                        /*onCompleted*/() -> System.out.println("We are done..."));
    }
}