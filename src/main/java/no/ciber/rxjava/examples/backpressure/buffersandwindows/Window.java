package no.ciber.rxjava.examples.backpressure.buffersandwindows;

import no.ciber.rxjava.examples.backpressure.util.BurstyIntegerObservable;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Window {
    //https://github.com/ReactiveX/RxJava/wiki/Backpressure#window

    public static void main(String[] args) {
        BurstyIntegerObservable.create()
                .window(1, TimeUnit.SECONDS)
                //OR count
                //.window(3)
                //OR timespan or count
                //.window(1, TimeUnit.SECONDS, 3)
                .toBlocking()
                .forEach(s -> s.doOnSubscribe(
                                    () -> System.out.println("--- start window---"))
                               .subscribe(
                                       System.out::println,
                                       System.out::println,
                                       () -> System.out.println("--end window--")));
    }
}
