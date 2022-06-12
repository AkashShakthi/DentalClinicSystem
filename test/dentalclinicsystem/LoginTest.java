/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dentalclinicsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author akash
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of LoggerName method, of class Login.
     */
    @Test
    public void testLoggerName() {
        System.out.println("LoggerName");
        Login instance = new Login();
        String expResult = "";
        String result = instance.LoggerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of loginValidator method, of class Login.
     */
    @Test
    public void testLoginValidator() {
        System.out.println("loginValidator");
        String loggermail = "";
        String loggerpasword = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.loginValidator(loggermail, loggerpasword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class Login.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        Login instance = new Login();
        instance.logout();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Login.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Login.main(args);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
}
