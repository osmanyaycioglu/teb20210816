package com.ee.training.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class StatelessCalculator {

    private int prevTotal = 0;

    public StatelessCalculator() {
    }

    public int add(final int a,
                   final int b) {
        int total = a + b;
        this.prevTotal += total;
        return total;
    }

    public int getPrevTotal() {
        return this.prevTotal;
    }


}
