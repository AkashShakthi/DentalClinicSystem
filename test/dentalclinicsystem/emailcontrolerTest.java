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
public class emailcontrolerTest {
    
    public emailcontrolerTest() {
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
     * Test of emailSender method, of class emailcontroler.
     */
    @Test
    public void testEmailSender() {
        System.out.println("emailSender");
        emailcontroler instance = new emailcontroler();
        instance.emailSender();
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of getAppointmentMailData method, of class emailcontroler.
     */
    @Test
    public void testGetAppointmentMailData() {
        System.out.println("getAppointmentMailData");
        String name = "";
        String treat = "";
        String date = "";
        String time = "";
        emailcontroler instance = new emailcontroler();
        instance.getAppointmentMailData(name, treat, date, time);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class emailcontroler.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        emailcontroler.main(args);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
