import com.mycompany.prog5121_part1.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;

public class PROG_Part1_UnitTesting {
     
   @Test
   public void testUsername1(){// Tests whether username is valid//(Wanvig, 2022)
       Login test1 = new Login("","","","");//(Wanvig, 2022)
       String Actual = test1.registerUser("kyl_1", "");//(Wanvig, 2022)
       String Expected = "Welcome <user first name>, <user last name> it is great to see you.";//(Wanvig, 2022)
       
       Assertions.assertEquals(Expected, Actual);//(Dexter, 2007)
      
       
   }
   @Test 
   public void testUsername2(){// Tests whether username is not valid
       Login test2 = new Login("","","","");//(Wanvig, 2022)
       String Actual = test2.registerUser("kyle!!!!!!!", "");//(Wanvig, 2022)
       String Expected = "Username is not correctly formatted, please ensure that your username contains an underscore"//(Wanvig, 2022)
                       + " and is no more than 5 characters in length.";//(Wanvig, 2022)
       
       Assertions.assertEquals(Expected, Actual);//v
       
   }
   
   @Test
   public void testPassword1(){// Tests whether password is valid(Wanvig, 2022)
       Login test3 = new Login("","","","");//(Wanvig, 2022)
       String Actual = test3.registerUser("", "Ch&&sec@ke99!");//(Wanvig, 2022)
       String Expected = "Password captured successfully";//(Wanvig, 2022)
       
       Assertions.assertEquals(Expected, Actual);//(Wanvig, 2022)
   }
   
   @Test
   public void testPassword2(){// Tests whether passsword is not valid(Wanvig, 2022)
       Login test4 = new Login("","","","");//(Wanvig, 2022)
        String Actual = test4.registerUser("", "password");//(Wanvig, 2022)
        String Expected = "Password is not correctly formatted, please ensure that the password contains at least 8 characters,"//(Wanvig, 2022)
               + " a capital letter, a number and a special character.";//(Wanvig, 2022)
          
       Assertions.assertEquals(Expected, Actual);//(Wanvig, 2022)
   }
   
   @Test
   public void testLogintrue(){//Test for valid login(Wanvig, 2022)
       Login test4 = new Login("","","","");//(Wanvig, 2022)
       boolean Actual = test4.loginUser("kyl_1", "Ch%%secke99!");//(Wanvig, 2022)
       boolean Expected = true;//(Wanvig, 2022)
       
       Assertions.assertEquals(true, Actual);//(Wanvig, 2022)
   }
   
   @Test//Test for failed login
   public void testLoginfalse(){//(Wanvig, 2022)
       Login test5 = new Login("","","","");//(Wanvig, 2022)
       boolean Actual = test5.loginUser("kyle!!!!!!!", "password");//(Wanvig, 2022)
       boolean Expected = false;//(Wanvig, 2022)
       
       Assertions.assertEquals(false, Actual);//(Wanvig, 2022)
   }
   
   @Test//Test to see if username requirements are met
   public void testUsernametrue(){
       Login test6 = new Login("","","","");//(Wanvig, 2022)
       boolean Actual = test6.checkUserName("kyl_1");//(Wanvig, 2022)
       boolean Expected = true;//(Wanvig, 2022)
       
       Assertions.assertEquals(true, Actual);//(Wanvig, 2022)
       
   }
   public void testUsernamefalse(){//Test to see if username requirements are false
       Login test7 = new Login("","","","");//(Wanvig, 2022)
       boolean Actual = test7.checkUserName("kyle!!!!!!!");//(Wanvig, 2022)
       boolean Expected = false;//(Wanvig, 2022)
       
       Assertions.assertEquals(false, Actual);//(Wanvig, 2022)
       
       
   }
   
   public void testPasswordtrue(){//Test to see if password requirements are met
   Login test8 = new Login("","","","");//(Wanvig, 2022)
       boolean Actual = test8.checkPasswordComplexity("Ch&&sec@ke99!");//v
       boolean Expected = true;//(Wanvig, 2022)
       
       Assertions.assertEquals(true, Actual);//(Wanvig, 2022)
       
   }
    public void testPasswordfalse(){//Test to see if password requirements are false
    Login test9 = new Login("","","","");//(Wanvig, 2022)
       boolean Actual = test9.checkPasswordComplexity("password");//(Wanvig, 2022)
       boolean Expected = false;//(Wanvig, 2022)
       
       Assertions.assertEquals(false, Actual);//v
       
}
}

