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
public class patientTest {
    
    public patientTest() {
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
     * Test of addpatient method, of class patient.
     */
    @Test
    public void testAddpatient() {
        System.out.println("addpatient");
        patient instance = new patient();
        instance.addpatient();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of editpatient method, of class patient.
     */
    @Test
    public void testEditpatient() {
        System.out.println("editpatient");
        patient instance = new patient();
        instance.editpatient();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of DisplayPatient method, of class patient.
     *//*
    @Test
    public void testDisplayPatient() {
        System.out.println("DisplayPatient");
        patient instance = new patient();
        instance.DisplayPatient();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }*/

    /**
     * Test of Clear method, of class patient.
     *//*
    @Test
    public void testClear() {
        System.out.println("Clear");
        patient instance = new patient();
        instance.Clear();
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }*/

    /**
     * Test of main method, of class patient.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        patient.main(args);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
}
