package no.ciber.rxjava.examples.backpressure.util;

import rx.Observable;
import rx.Subscriber;

public class BurstyStringObservable extends BurstyObservableSupport<String> {

    private final String value;

    private final long sleepMillis;

    public BurstyStringObservable(String value, long sleepMillis) {
        this.value = value;
        this.sleepMillis = sleepMillis;
    }

    public static Observable<String> create(String value, long sleepMillis) {
        return (Observable<String>) new BurstyStringObservable(value, sleepMillis).instantiate();
    }

    @Override
    protected void produceBurstyData(Subscriber<? super String> s) {
        s.onNext(value);
    }

    @Override
    protected void sleep() throws InterruptedException {
        Thread.sleep(sleepMillis);
    }
}
