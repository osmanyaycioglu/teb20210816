package com.ee.training.cdi.interceptor;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;


@Retention(RUNTIME)
@Target({
          TYPE,
          FIELD,
          METHOD
})
@InterceptorBinding
public @interface Inter {
}
