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
     * Test of UserIdGenerator method, of class user.
     */
    @Test
    public void testUserCount() {
        System.out.println("userCount");
        user instance = new user();
        instance.UserIdGenerator();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

   

    /**
     * Test of createuser method, of class user.
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
        instance.createuser(Name, email, pass, conPass, userRoll, userMobile);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of edituser method, of class user.
     */
    @Test
    public void testEdituser() {
        System.out.println("edituser");
        int Key = 0;
        String Name = "akas";
        String email = "a";
        String pass = "a";
        String conPass = "a";
        String userRoll = "a";
        String userMobile = "a";
        user instance = new user();
        instance.edituser(Key, Name, email, pass, conPass, userRoll, userMobile);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteuser method, of class user.
     */
    @Test
    public void testDeleteuser() {
        System.out.println("deleteuser");
        int Key = 0;
        user instance = new user();
        instance.deleteuser(Key);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    

   

 

    /**
     * Test of logout method, of class user.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        user instance = new user();
        instance.logout();
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
       // fail("The test case is a prototype.");
    }
    
}
