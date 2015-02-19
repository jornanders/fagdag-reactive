package no.ciber.rxjava.examples.functionalconcepts;

/**
 *
 */
public class SideEffect {

    private int state = 0;

    // pure function
    // call this method any number of times - with any number of threads, always the same answer
    // for the same parameter (totally determined by the incoming parameters and nothing else)
    public int f1(int x) {
        return x * 2;
    }

    //impure function
    public int f2(int x) {
        state = (++state % 3);
        return x * 2 + state;
    }

    public static void main(String[] args) {
        SideEffect v = new SideEffect();
        for (int i = 0; i < 100; i++) {
            if (v.f1(5) != 10) {
                throw new IllegalStateException();
            }
        }
        System.out.println("f1(5) = 10 for all calls");

        for (int i = 0; i < 100; i++) {
            System.out.println("f2(5) = " + v.f2(5));
        }
    }
}
