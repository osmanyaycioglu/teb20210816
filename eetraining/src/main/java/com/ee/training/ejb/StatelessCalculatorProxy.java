package com.ee.training.ejb;

public class StatelessCalculatorProxy extends StatelessCalculator {

    private StatelessCalculator realInstance;

    public StatelessCalculatorProxy(final StatelessCalculator realInstanceParam) {
        super();
        this.realInstance = realInstanceParam;
    }

    @Override
    public int add(final int a,
                   final int b) {
        //        System.out.println("log");
        //        if (a < 0) {
        //            return 0;
        //        }
        // this.realInstance = pool.get();
        int addLoc = this.realInstance.add(a,
                                           b);
        // pool.give(this.realInstance);
        this.realInstance = null;
        return addLoc;
    }

    @Override
    public int getPrevTotal() {
        return this.realInstance.getPrevTotal();
    }


}
