package com.ee.training.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;


@Singleton
@LocalBean
public class SingletonCalculator {

    private int prevTotal = 0;
    //Yanlış
    // private final List<String> strliList = new ArrayList<>();
    // Doğru
    //    private final List<String> strliList = new Vector<>();
    //    private final List<String> strliList = Collections.synchronizedList(new ArrayList<>());
    // Yanlış
    //Map<String, String> str = new HashMap<>();
    // Doğru
    //Map<String, String> str = new ConcurrentHashMap<>();
    // yanlış
    // long counter = 0;
    // Doğru
    // AtomicLong atomicLong = new AtomicLong();

    public SingletonCalculator() {
    }

    @Lock(LockType.WRITE)
    public int add(final int a,
                   final int b) {
        int total = a + b;
        this.setPrevTotal(total);
        return total;
    }

    @Lock(LockType.READ)
    public int getPrevTotal() {
        return this.prevTotal;
    }

    public synchronized void setPrevTotal(final int total) {
        this.prevTotal += total;
    }


}
