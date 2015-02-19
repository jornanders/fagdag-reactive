package no.ciber.rxjava.examples.backpressure.util;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 *
 */
public abstract class BurstyObservableSupport<T> {
    protected final Observable<? super T> instantiate() {
        return Observable.create((Subscriber<? super T> s) -> {
            while (!s.isUnsubscribed()) {
                // burst some number of items
                System.out.println("----start burst----");
                produceBurstyData(s);
                System.out.println("----end burst----");
                try {
                    sleep();
                } catch (Exception e) {
                    // do nothing
                }
            }
        }).subscribeOn(Schedulers.newThread()); // use newThread since we are using sleep to block
    }

    protected abstract void produceBurstyData(Subscriber<? super T> s);

    protected void sleep() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 1000));
    }
}
