package com.ee.training.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         message;
    private int            cause;


    public ErrorObj() {
    }

    public ErrorObj(final String messageParam,
                    final int causeParam,
                    final List<ErrorObj> subErrorsParam) {
        super();
        this.subErrors = subErrorsParam;
        this.message = messageParam;
        this.cause = causeParam;
    }

    public ErrorObj(final String messageParam,
                    final int causeParam) {
        super();
        this.message = messageParam;
        this.cause = causeParam;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public ErrorObj add(final ErrorObj errorObjParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjParam);
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorObj setMessage(final String messageParam) {
        this.message = messageParam;
        return this;
    }

    public int getCause() {
        return this.cause;
    }

    public ErrorObj setCause(final int causeParam) {
        this.cause = causeParam;
        return this;
    }

    public static void main(final String[] args) {
        ErrorObj errorObjLoc = new ErrorObj("error oluştu",
                                            100);
        List<ErrorObj> subErrorListLoc = new ArrayList<>();
        subErrorListLoc.add(errorObjLoc);
        ErrorObj rootObjLoc = new ErrorObj("root error",
                                           200,
                                           subErrorListLoc);

        ErrorObj errorObjLoc2 = new ErrorObj().setMessage("root error")
                                              .setCause(200)
                                              .add(new ErrorObj().setMessage("error oluştu")
                                                                 .setCause(100))
                                              .add(new ErrorObj().setMessage("error oluştu 2")
                                                                 .setCause(101)
                                                                 .add(new ErrorObj().setMessage("alt error oluştu")
                                                                                    .setCause(300)));

    }
}
