import com.mycompany.prog5121_part1.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;

public class PROG_Part1_UnitTesting {
     
   @Test
   public void testUsername(){
       Login test1 = new Login("","","","");
       boolean Actual = test1.checkUserName("kyl_1");
       boolean Expected = true;
       
      Assertions.assertEquals(Expected, Actual);
      
       
   }
   @Test
   public void testPassword(){
       Login test2 = new Login("","","","");
       boolean Actual = test2.checkPasswordComplexity("Ch&&sec@ke99");
       boolean Expected = true;
       
       Assertions.assertEquals(Expected, Actual);
   }
   
   @Test
   public void testLoginUser(){
       Login test3 = new Login("","","","");
        boolean Actual = test3.loginUser("kyl_1", "Ch&&sec@ke99" );
        boolean Expected = false;
          
       
   }
   
   /*@Test
   public void testRegisterUser(){
       Login test4 = new Login("","","","");
       String Actual = test4.loginUser(, Password1);
       String Expected = true;
       
       Assertions.assertTrue(true, Actual)
   }
   
   @Test
   public void testReturnMessage(){
       Login test5 = new Login("","","","");
       
       
       
   }*/
   

}

