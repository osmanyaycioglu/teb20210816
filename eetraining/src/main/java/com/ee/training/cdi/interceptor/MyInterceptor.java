package com.ee.training.cdi.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Inter
public class MyInterceptor {

    @AroundInvoke
    public Object beforeMethod(final InvocationContext ic) {
        try {
            Method methodLoc = ic.getMethod();
            Object[] parametersLoc = ic.getParameters();
            Object[] parametersRealLoc = new Object[parametersLoc.length];
            for (int iLoc = 0; iLoc < parametersLoc.length; iLoc++) {
                if (parametersLoc[iLoc] instanceof String) {
                    String str = (String) parametersLoc[iLoc];
                    str += " intercepted";
                    parametersRealLoc[iLoc] = str;
                } else {
                    parametersRealLoc[iLoc] = parametersLoc[iLoc];
                }

            }
            ic.setParameters(parametersRealLoc);
            String str = Arrays.stream(parametersLoc)
                               .map(o -> o.toString())
                               .collect(Collectors.joining(","));

            System.out.println("Method : " + methodLoc.getName() + " Params  : " + str);
            long nanoTimeLoc = System.nanoTime();
            Object proceedLoc = ic.proceed();
            System.out.println("Method : "
                               + methodLoc.getName()
                               + " Delta execution : "
                               + (System.nanoTime() - nanoTimeLoc));
            if (proceedLoc instanceof String) {
                String s = (String) proceedLoc;
                return "returned value changed : " + s;
            }
            return proceedLoc;
        } catch (Throwable eLoc) {
            return null;
        }
    }

}
