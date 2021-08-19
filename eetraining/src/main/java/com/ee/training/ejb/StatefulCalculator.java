package com.ee.training.ejb;

import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;


@Stateful
@LocalBean
public class StatefulCalculator {

    private int prevTotal = 0;

    public StatefulCalculator() {
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

    @Remove
    public void remove() {
    }

    @PrePassivate
    public void beforeSerialize() {
    }

    @PostActivate
    public void afterObject() {
    }

}
