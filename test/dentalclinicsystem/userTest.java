/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dentalclinicsystem;

import java.sql.ResultSet;
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
public class userTest {
    
    public userTest() {
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
     * Test of IdGenerator method, of class user.
     */
    @Test
    public void testIdGenerator() {
        System.out.println("IdGenerator");
        String idColumnName = "Patid";
        String Tablename = "PatientTBL";
        user instance = new user();
        instance.IdGenerator(idColumnName, Tablename);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of createData method, of class user.
     */
    @Test
    public void testCreateuser() {
        System.out.println("createuser");
        String Name = "";
        String email = "";
        String pass = "";
        String conPass = "";
        String userRoll = "";
        String userMobile = "";
        user instance = new user();
        instance.createData(Name, email, pass, conPass, userRoll, userMobile);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editData method, of class user.
     */
    @Test
    public void testEdituser() {
        System.out.println("edituser");
        int Key = 0;
        String Name = "";
        String email = "";
        String pass = "";
        String conPass = "";
        String userRoll = "";
        String userMobile = "";
        user instance = new user();
        instance.editData(Key, Name, email, pass, conPass, userRoll, userMobile);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteData method, of class user.
     */
    @Test
    public void testDeleteuser() {
        System.out.println("deleteuser");
        int Key = 0;
        String ColumenNameOfID = "";
        String tableName = "";
        user instance = new user();
        instance.deleteData(Key, ColumenNameOfID, tableName);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of displayuser method, of class user.
     */
 /*   @Test
    public void testDisplayuser() {
        System.out.println("displayData");
        String UserRoll = "";
        user instance = new user();
        ResultSet expResult = null;
        ResultSet result = instance.displayData(UserRoll);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }*/

    /**
     * Test of PasswordEncryptor method, of class user.
     */
  /*  @Test
    public void testPasswordEncryptor() {
        System.out.println("PasswordEncryptor");
        String text = "";
        user instance = new user();
        String expResult = "";
        String result = instance.PasswordEncryptor(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }*/

    /**
     * Test of CheckDataAlradyExist method, of class user.
     */
    @Test
    public void testCheckDataAlradyExist() {
        System.out.println("CheckDataAlradyExist");
        String value = "";
        String ColumnNameOfValue = "";
        String tableName = "";
        String tableID = "";
        user instance = new user();
        int expResult = 0;
        int result = instance.CheckDataAlradyExist(value, ColumnNameOfValue, tableName, tableID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class user.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        user.main(args);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
}
