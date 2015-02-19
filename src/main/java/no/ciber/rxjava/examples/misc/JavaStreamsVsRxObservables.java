package no.ciber.rxjava.examples.misc;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 *
 */
public class JavaStreamsVsRxObservables {

    public static void main(String[] args) throws InterruptedException {

        javaStreams();
        rxObservables();
    }

    public static void javaStreams() {
        Stream<String> s1 = Stream.of("Per", "Ola", "Hans", "Lisa", "Linda");
        Stream s2 = s1.map(s -> "a:" + s.toUpperCase());
        //pull
        for (Iterator<String> it = s2.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
        //OR!!
        //push
        //s2.forEach(System.out::println);
    }

    public static void rxObservables() throws InterruptedException {
        Observable<String> obs1 = Observable.just("Per", "Ola", "Hans", "Lisa", "Linda");
        Observable<String> obs2 = obs1.map(s -> "b: " + s.toLowerCase());

        //ONLY PUSH in RxJava

        //RxJava by default single threaded
        obs2/*.subscribeOn(Schedulers.newThread())
            .toBlocking()*/
            .forEach(System.out::println);
        System.out.println("Completed!!");

        //REUSE of observables
        /*
        obs1.map(s -> "c: " + s.toUpperCase())
            .subscribe(System.out::println);

        obs2.filter(s -> s.endsWith("a"))
            .map(s -> "ends with a: " + s)
            .subscribe(System.out::println);
        */
    }
}
