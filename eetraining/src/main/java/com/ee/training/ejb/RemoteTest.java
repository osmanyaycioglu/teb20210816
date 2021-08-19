package com.ee.training.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class RemoteTest
 */
@Stateless
@Remote
public class RemoteTest implements RemoteTestRemote {

    public RemoteTest() {
        // TODO Auto-generated constructor stub
    }

}
