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
public class mailcontrolTest {
    
    public mailcontrolTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("calling the @beforeClass");
    }
    
    @AfterClass
    public static void tearDownClass() {
         System.out.println("calling the @AfterClass");
    }
    
    @Before
    public void setUp() {
         System.out.println("calling the before method (@before foreach)");
    }
    
    @After
    public void tearDown() {
        System.out.println("calling the after method (@after foreach)");
    }

    /**
     * Test of email method, of class mailcontrol.
     */
   /* @Test
    public void testEmail() {
        System.out.println("email");
        mailcontrol instance = new mailcontrol();
        instance.email();
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }*/

    /**
     * Test of storemaildata method, of class mailcontrol.
     */
    @Test
    public void testStoremaildata() {
        System.out.println("storemaildata");
        String name = "Akash Shakthi";
        String treat = "Extractions";
        String date = "Wed Jun 15 23:57:05 IST 2022";
        String time = "09:00Am";
        mailcontrol instance = new mailcontrol();
        instance.storemaildata(name, treat, date, time);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class mailcontrol.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        mailcontrol.main(args);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
