package com.ee.training.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class LocalTest
 */
@Stateless
@Local
public class LocalTest implements LocalTestLocal {

    /**
     * Default constructor.
     */
    public LocalTest() {
        // TODO Auto-generated constructor stub
    }

}
